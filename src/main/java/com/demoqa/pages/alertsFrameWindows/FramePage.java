package com.demoqa.pages.alertsFrameWindows;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class FramePage extends BasePage {

    public FramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> iframe;

    public FramePage returnListOfFrames() {
        //by finding all the web elements using method size()
        System.out.println("The total number of iframes are " + iframe.size());

        //by executing java script
        Integer numberOfIframes = Integer.parseInt(js.executeScript("return window.length").toString());
        System.out.println("The total number of iframes are" + numberOfIframes);
        return this;
    }

    public FramePage switchToIframeByIndex(int index) {
        driver.switchTo().frame(index);
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public FramePage verifyIframeByText(String text) {
        Assert.assertTrue(shouldHaveText(sampleHeading, text, 1));
        return this;
    }

    @FindBy(id = "frame1")
    WebElement frame1;

    public FramePage switchToIframeById() {
        driver.switchTo().frame(frame1);
        return this;
    }

    public FramePage switchToMainPage() {
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(tagName = "h1")
    WebElement title;

    public FramePage verifyMainPageByTitle(String text) {
        Assert.assertTrue(title.getText().contains(text));
        return this;
    }

    @FindBy(tagName = "body")
    WebElement body;

    public FramePage handleNestadIframes() {
        //switch to parent iframe
        driver.switchTo().frame(frame1);

        //get text from parent iframe
        System.out.println("Iframe is " + body.getText());

//number of iframes in parent
        System.out.println("Number of iframes inside parent iframe is " + iframe.size());

        //switch to child frame
        driver.switchTo().frame(0);
        System.out.println("iframe is " + body.getText());

        //switch to parent iframe
        driver.switchTo().parentFrame();
        System.out.println("Iframe is " + body.getText());
        return this;
    }
}
