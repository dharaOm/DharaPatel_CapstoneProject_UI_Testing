package com.alexandnova.dharapatel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    WebDriver driver;

    By clearanceLink = By.id("navigation-clearance");
    By faceCoveringLink = By.cssSelector("#navigation-face-covering");
            //.id("navigation-face-covering");
    //*[@id="navigation-face-covering"]

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickClearanceLink()
    {
        driver.findElement(clearanceLink).click();
    }

    public void clickFaceCoveringLink()
    {
        driver.findElement(faceCoveringLink).click();
    }


    // this is the xpath for iframe (for handling pop up)
    //iframe[@id='ju_iframe_486652']

    //this is xpath to click on I'd rather pay full price
    //*[@id="justuno_form"]/div/div[2]/div[13]/div/div/div/span/span/strong
    //**OR TRY THIS**  //strong[contains(text(),"No, I'd rather pay full price.")]

    //here is the xpath to click 'X' to close the pop up window
    //span[contains(text(),'x')]
    // OR THIS**  //*[@id="justuno_form"]/div/div[2]/div[1]/div/div/div/span
}
