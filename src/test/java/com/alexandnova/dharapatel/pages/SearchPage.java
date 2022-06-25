package com.alexandnova.dharapatel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

    WebDriver driver;

    By searchField = By.name("q");
    //WebElement search = driver.findElement(By.name("q"));
    By searchIcon = By.className("header-search-button");
    By searchResults = By.xpath("//*[@id=\"keyboard-nav-3\"]/h1/span[1]");
    By blankSearchMessage = By.cssSelector("#isp_search_results_container > li.isp_no_results_title");
    //*[@id="isp_search_results_container"]/li[1]

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchItem(String product)
    {
        driver.findElement(searchField).sendKeys(product);
    }

//    public void clearSearchField()
//    {
//        search.clear();
//    }
    public void clickSearchIcon()
    {
        driver.findElement(searchIcon).click();
    }
    public String getBlankSearchResultMessage()
    {
        return driver.findElement(blankSearchMessage).getText();
    }

    public boolean searchResultPageDisplayed()
    {
        return driver.findElement(searchResults).isDisplayed();
    }





}
