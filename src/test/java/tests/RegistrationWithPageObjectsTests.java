package tests;

import org.junit.jupiter.api.*;
import pages.RegistrationPage;
import utils.TestData;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData data = new TestData();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(data.firstName)
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
    }

    @Test
    void successfulValidateRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setUserNumber(data.phoneNumber)
                .submit();

        registrationPage.checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.phoneNumber);
        registrationPage.tableResultAppear();
    }

    @Test
    void negativeValidateRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setUserNumber(data.phoneNumber)
                .submit();

        registrationPage.tableResultHidden();
    }
}