package tests;

import org.junit.jupiter.api.*;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Test")
                .setLastName("Testes")
                .setEmail("test@test.com")
                .setGender("Other")
                .setUserNumber("8909876543")
                .setDateOfBirth("28", "May", "2018")
                .setSubjects("Computer Science")
                .setHobbies("Sports")
                .setPicture("Picture.jpg")
                .setCurrentAddress("Street Test 1")
                .setState("Uttar Pradesh")
                .setCity("Lucknow")
                .submit();

        registrationPage.checkResult("Student Name", "Test Testes")
                .checkResult("Student Email", "test@test.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "8909876543")
                .checkResult("Date of Birth", "28 May,2018")
                .checkResult("Subjects", "Computer Science")
                .checkResult("Hobbies", "Sport")
                .checkResult("Picture", "Picture.jpg")
                .checkResult("Address", "Street Test 1")
                .checkResult("State and City", "Uttar Pradesh Lucknow");

        registrationPage.tableResultAppear();
    }

    @Test
    void successfulValidateRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Test")
                .setLastName("Testes")
                .setGender("Other")
                .setUserNumber("8909876543")
                .submit();

        registrationPage.checkResult("Student Name", "Test Testes")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "8909876543");
        registrationPage.tableResultAppear();
    }

    @Test
    void negativeValidateRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Test")
                .setLastName("Testes")
                .setUserNumber("8909876543")
                .submit();

        registrationPage.tableResultHidden();
    }
}