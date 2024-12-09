package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.elements.ButtonsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getElements();
        new SidePanel(driver).selectButtons().hideIframes();
    }

    @Test
    public void doubleClickTest() {
        new ButtonsPage(driver).doubleClick();
    }

    @Test
    public void rightClickTest() {
        new ButtonsPage(driver).rightClick();
    }
}
