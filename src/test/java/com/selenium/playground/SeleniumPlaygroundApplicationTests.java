package com.selenium.playground;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeleniumPlaygroundApplicationTests {

	@Autowired
	private DriverProvider driverProvider;

	@Test
	public void contextLoads() {
        WebDriver webDriver = driverProvider.getWebDriver();
        webDriver.get("https://www.google.com");
        webDriver.quit();
	}

}
