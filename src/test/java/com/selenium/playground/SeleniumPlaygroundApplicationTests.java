package com.selenium.playground;

import com.selenium.playground.pages.Results;
import com.selenium.playground.pages.TimeHome;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.DockerComposeContainer;

import java.io.File;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeleniumPlaygroundApplicationTests {

	@Autowired
	private DriverProvider driverProvider;


	public DockerComposeContainer environment =
			new DockerComposeContainer(new File("docker-compose.yml"))
					.withExposedService("selenium-hub", 4444)
					.withExposedService("chrome", 5555)
					.withExposedService("firefox", 5555)
					.withLocalCompose(false);

	//@Rule
	public DockerComposeContainer videoEnvironment =
			new DockerComposeContainer(new File("docker-compose-video.yml"))
					.withServices("chrome_video")
					.withLocalCompose(false);

	@Test
	public void contextLoads() throws InterruptedException {

		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("enable-automation");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation");
		options.addArguments("--disable-gpu");
		driver = new ChromeDriver(options);
		driver.get("https://www.time.mk/");


		new TimeHome(driver)
				.searchCatOne("broj")
				.clickCatOneOnResults()
				.withFirstMenuItem(s -> assertEquals("Vesti", s))
				.inputSearchOnResults("Search");



		//Thread.sleep(30000);
//        WebDriver webDriver = driverProvider.getWebDriver();
//        webDriver.get("https://www.google.com");
//        webDriver.quit();
	}

}
