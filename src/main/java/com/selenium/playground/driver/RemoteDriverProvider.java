package com.selenium.playground.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

@Component
class RemoteDriverProvider {

    @Value("${remote.driver.url:http://localhost:4444/wd/hub}")
    private String remoteDriverUrl;

    WebDriver getWebDriver(DesiredCapabilities desiredCapabilities) throws MalformedURLException {
        return new RemoteWebDriver(new URL(remoteDriverUrl), desiredCapabilities);
    }
}
