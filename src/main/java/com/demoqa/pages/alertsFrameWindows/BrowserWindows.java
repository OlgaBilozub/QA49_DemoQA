package com.demoqa.pages.alertsFrameWindows;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindows extends BasePage {

    public BrowserWindows(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    WebElement tabButton;

    public BrowserWindows switchToNewTab(int index) {
        click(tabButton);

        List<String>tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }
    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;


    public BrowserWindows verifyNewTabTitle(String text) {
        Assert.assertTrue(shouldHaveText(sampleHeading,text,5));
        return this;
    }
}
