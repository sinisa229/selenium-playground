package com.selenium.playground.widget;

import org.openqa.selenium.WebElement;

public class Header {
    private WebElement koronavirus;
    private WebElement prognoza;

    public void clickKorona() {
        koronavirus.click();
    }

    public void clickPrognoza() {
        prognoza.click();
    }
}
