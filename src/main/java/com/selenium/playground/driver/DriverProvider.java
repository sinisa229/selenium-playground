package com.selenium.playground.driver;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

public interface DriverProvider {
    @SneakyThrows
    WebDriver getWebDriver();
}
