package com.demoqa.pages.forms;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.security.Key;
import java.util.concurrent.CompletionService;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userNumber")
    WebElement userNumber;

    public PracticeFormPage enterPersonalData(String name, String surName, String email, String phone) {
        typeWithJS(firstName, name, 0, 300);
        type(lastName, surName);
        type(userEmail, email);
        type(userNumber, phone);
        return this;
    }

    @FindBy(css = "[for='gender-radio-1']")
    WebElement male;

    @FindBy(css = "[for='gender-radio-2']")
    WebElement female;

    @FindBy(css = "[for='gender-radio-3']")
    WebElement other;

    public PracticeFormPage selectGender(String gender) {
        if (gender.equals("Male")) {
            click(male);
        } else if (gender.equals("Female")) {
            click(female);
        } else {
            click(other);
        }
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;

    public PracticeFormPage enterDate(String date) {
        click(dateOfBirthInput);

        String os = System.getProperty("os.name");
        System.out.println("My OS is " + os);

        if (os.startsWith("Mac")) {
            dateOfBirthInput.sendKeys(Keys.COMMAND, "a");
        } else {
            dateOfBirthInput.sendKeys(Keys.CONTROL, "a");
        }
        dateOfBirthInput.sendKeys(date);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage addSubjects(String[] subjects) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                typeWithJS(subjectsInput, subjects[i], 0, 300);
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }

@FindBy(css="[for='hobbies-checkbox-1']")
WebElement sports;

    @FindBy(css = "[for='hobbies-checkbox-2']")
    WebElement reading;

    @FindBy(css = "[for='hobbies-checkbox-3']")
    WebElement music;

    public PracticeFormPage selectHobby(String[] hobby) {
        for (int i = 0; i < hobby.length ; i++) {
            if (hobby[i].equals("Sports")){
                click(sports);
            }if (hobby[i].equals("Reading")){
                click(reading);
            }if (hobby[i].equals("Music")){
                click(music);
            }
        }
        return this;
    }
@FindBy(id = "uploadPicture")
WebElement uploadPicture;
    public PracticeFormPage uploadFile(String path) {
       uploadPicture.sendKeys(path);
        return this;
    }
@FindBy(id = "react-select-3-input")
WebElement stateInput;

    public PracticeFormPage inputState(String state) {
stateInput.sendKeys(state);
stateInput.sendKeys(Keys.ENTER);
        return this;
    }
    @FindBy(id = "react-select-4-input")
    WebElement cityInput;

    public PracticeFormPage inputCity(String city) {
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);
        return this;
    }
    @FindBy(id = "submit")
    WebElement submit;

    public PracticeFormPage submit() {
        click(submit);
        return this;
    }
    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement modalTitle;

    public PracticeFormPage verifySuccessRegistration(String title) {
        Assert.assertTrue(shouldHaveText(modalTitle,title,5));
        return this;
    }
@FindBy(css = ".react-datepicker__month-select")
WebElement monthOption;

    @FindBy(css = ".react-datepicker__year-select")
    WebElement yearOption;

    public PracticeFormPage selectDate(String month, String year, String day) {
        click(dateOfBirthInput);

new Select(monthOption).selectByVisibleText(month);
new Select(yearOption).selectByVisibleText(year);



        driver.findElement(By.xpath("//div[.='"+ day + "']")).click();
        return this;
    }
}
