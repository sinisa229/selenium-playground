package com.selenium.playground.driver;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import static org.openqa.selenium.remote.DesiredCapabilities.chrome;

@Component
@RequiredArgsConstructor
public class RemoteChromeProvider implements DriverProvider {

    private final RemoteDriverProvider remoteDriverProvider;

    @Override
    @SneakyThrows
    public WebDriver getWebDriver() {
        return remoteDriverProvider.getWebDriver(chrome());
    }

}
