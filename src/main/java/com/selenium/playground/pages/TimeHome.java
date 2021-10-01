package com.selenium.playground.pages;

import com.selenium.playground.widget.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimeHome {

    private final WebDriver webDriver;
    @FindBy(id = "c1")
    private WebElement categoryOne;
    @FindBy(id = "c2")
    private WebElement categoryTwo;
    @FindBy(id = "c3")
    private WebElement categoryThree;
    @FindBy(id = "c4")
    private WebElement categoryFour;
    @FindBy(id = "searchmain")
    private WebElement search;
    @FindBy(className = "send")
    private WebElement searchSubmit;

    private Header header;

    public TimeHome(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public TimeHome clickCatOne() {
        categoryOne.click();
        return this;
    }

    public Results inputSearch(String searchTerm) {
        search.sendKeys(searchTerm);
        searchSubmit.click();
        return new Results(webDriver);
    }

    public Results searchCatOne(String searchTerm) {
        return clickCatOne().inputSearch(searchTerm);
    }

    public TimeHome clickKorona() {
        header.clickKorona();
        return this;
    }

    public TimeHome clickPrognoza() {
        header.clickPrognoza();
        return this;
    }
}
