package com.selenium.playground.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.function.Consumer;

public class Results {

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

    public Results(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public Results clickCatOneOnResults() {
        categoryOne.click();
        return this;
    }

    public Results inputSearchOnResults(String searchTerm) {
        search.sendKeys(searchTerm);
        searchSubmit.click();
        return this;
    }

    public Results withFirstMenuItem(Consumer<String> consumer) {
        consumer.accept(categoryOne.getText());
        return this;
    }

    public String getFirstMenuItem() {
        return categoryOne.getText();
    }
}
