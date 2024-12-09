package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.forms.PracticeFormPage;
import com.demoqa.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTest extends TestBase{

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm().hideIframes();
    }
    @Test(dataProviderClass = DataProviders.class,dataProvider = "addNewStudentWithCvs")
    public void createStudentAccount(String name,String lastName, String email,String phone){
        new PracticeFormPage(driver)
                .enterPersonalData(name,lastName,email,phone)
                  .selectGender("Female")
                  .enterDate("20 Apr 1984")
                  .addSubjects(new String[]{"Math","Chemistry"})
                  .selectHobby(new String[]{"Sports","Reading"})
                  .uploadFile("C:\\Users\\alona\\OneDrive\\Документы\\Snapchat-2095367846.jpg")
                  .inputState("NCR")
                  .inputCity("Delhi")
                  .submit()
                  .verifySuccessRegistration("Thanks for submitting the form");
    }
    @Test
    public void createStudentAccountWithSelectDate(){
        new PracticeFormPage(driver).enterPersonalData("Marina","Karam","karam@gm.com","1234567890")
                .selectGender("Female")
                .selectDate("April","1984","20")
                .addSubjects(new String[]{"Math","Chemistry"})
                .selectHobby(new String[]{"Sports","Reading"})
                .uploadFile("C:\\Users\\alona\\OneDrive\\Документы\\Snapchat-2095367846.jpg")
                .inputState("NCR")
                .inputCity("Delhi")
                .submit()
                .verifySuccessRegistration("Thanks for submitting the form")
        ;
    }
}
