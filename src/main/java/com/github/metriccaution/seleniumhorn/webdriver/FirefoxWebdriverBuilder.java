package com.github.metriccaution.seleniumhorn.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxWebdriverBuilder implements WebdriverBuilder {
	@Override
	public WebDriver build() {
		final WebDriver driver = new FirefoxDriver();
		return driver;
	}
}
