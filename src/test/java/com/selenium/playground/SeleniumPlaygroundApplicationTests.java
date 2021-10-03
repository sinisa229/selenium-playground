package com.selenium.playground;

import com.selenium.playground.driver.DriverProvider;
import com.selenium.playground.pages.TimeHome;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.DockerComposeContainer;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeleniumPlaygroundApplicationTests {

	@Rule
	public DockerComposeContainer environment = new DockerSeleniumGridProvider().getGrid();

	@Autowired
	private DriverProvider driverProvider;

	private WebDriver driver;

	@Before
	public void setUp() {
		driver = driverProvider.getWebDriver();
		driver.get("https://www.time.mk/");
	}

	@Test
	public void clickAround() {

		new TimeHome(driver)
				.inputSearch("broj")
				.clickCatOneOnResults()
				.withFirstMenuItem(s -> assertEquals("Vesti", s))
				.inputSearchOnResults("Search");
	}

}
