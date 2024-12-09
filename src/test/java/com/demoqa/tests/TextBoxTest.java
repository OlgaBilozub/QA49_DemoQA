package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.elements.TextBoxPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TextBoxTest extends TestBase {
    @BeforeMethod
    public void  precondition(){
        new HomePage(driver).getElements();
        new SidePanel(driver).selectTextBox();

    }
    @Test
    @Parameters({"name","email","address"})

    public void  keyBoardEventTest(String name, String email, String address){
         new TextBoxPage(driver).enterData(name,email)
                 .keyBoardEvent(address)
                .submit()
                .verifyCopyPastText();
    }
}
