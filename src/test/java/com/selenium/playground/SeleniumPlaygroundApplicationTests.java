package com.selenium.playground;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeleniumPlaygroundApplicationTests {

	@Autowired
	private DriverProvider driverProvider;

	@Rule
	public DockerComposeContainer environment =
			new DockerComposeContainer(new File("docker-compose.yml"))
					.withExposedService("selenium-hub", 4444)
					.withExposedService("chrome", 5555)
					.withExposedService("firefox", 5555)
					.withLocalCompose(false);

	@Test
	public void contextLoads() {
        WebDriver webDriver = driverProvider.getWebDriver();
        webDriver.get("https://www.google.com");
        webDriver.quit();
	}

}
