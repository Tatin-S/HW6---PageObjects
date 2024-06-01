package tests;

import org.junit.jupiter.api.*;
import pages.RegistrationPage;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

@Tag("registration")
public class RegistrationWithPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @DisplayName("Регистрация с заполнением всех полей")
    void successfulRegistrationTest() {
        step("Открыть форму регистрации", () -> {
            registrationPage.openPage();
            registrationPage.closeBanners();
        });
        step("Заполнить все поля и нажать submit", () -> {
            registrationPage.setFirstName(data.firstName)
                            .setLastName(data.lastName)
                            .setEmail(data.email)
                            .setGender(data.gender)
                            .setUserNumber(data.phoneNumber)
                            .setDateOfBirth(data.BirthDay, data.BirthMonth, data.BirthYear)
                            .setSubjects(data.subject)
                            .setHobbies(data.hobby)
                            .setPicture(data.picture)
                            .setCurrentAddress(data.currentAddress)
                            .setState(data.state)
                            .setCity(data.city)
                            .submit();
        });

        step("Проверить заполненные данные", () -> {
            registrationPage.checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Student Email", data.email)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.phoneNumber)
                .checkResult("Date of Birth", data.BirthDay + " " + data.BirthMonth + "," + data.BirthYear)
                .checkResult("Subjects", data.subject)
                .checkResult("Hobbies", data.hobby)
                .checkResult("Picture", data.picture)
                .checkResult("Address", data.currentAddress)
                .checkResult("State and City", data.state + " " + data.city);
            registrationPage.tableResultAppear();
        });
    }

    @Test
    @DisplayName("Регистрация с заполнением только обязательных полей")
    void successfulValidateRegistrationTest() {
        step("Открыть форму регистрации", () -> {
            registrationPage.openPage();
            registrationPage.closeBanners();
        });

        step("Заполнить обязательные поля и нажать submit", () -> {
        registrationPage.setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setUserNumber(data.phoneNumber)
                .submit();
        });

        step("Проверить заполненные данные", () -> {
        registrationPage.checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.phoneNumber);
        registrationPage.tableResultAppear();
        });
    }

    @Test
    @DisplayName("Регистрация с незаполненным обязательным полем Gender")
    void negativeValidateRegistrationTest() {
        step("Открыть форму регистрации", () -> {
            registrationPage.openPage();
            registrationPage.closeBanners();
        });

        step("Заполнить обязательные поля, кроме Gender, и нажать submit", () -> {
        registrationPage.setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setUserNumber(data.phoneNumber)
                .submit();
        registrationPage.tableResultHidden();
        });
    }
}