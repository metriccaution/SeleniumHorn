package com.github.metriccaution.seleniumhorn.runner;

import javax.inject.Inject;
import javax.script.Invocable;
import javax.script.ScriptEngine;

import org.openqa.selenium.WebDriver;

import com.github.metriccaution.seleniumhorn.scripting.ScriptEngineBuilder;
import com.github.metriccaution.seleniumhorn.webdriver.WebdriverBuilder;

public class SeleniumHornRunner1 implements SeleniumHornRunner {

	private final ScriptEngine engine;
	private final WebDriver driver;

	@Inject
	public SeleniumHornRunner1(final ScriptEngineBuilder seb,
			final WebdriverBuilder web) {
		engine = seb.build();
		driver = web.build();
	}

	private void script(final StringBuilder sb, final String text) {
		sb.append(text).append("\n");
	}

	@Override
	public void before() {
	}

	@Override
	public void run() {
		final StringBuilder sb = new StringBuilder();
		script(sb, "var run = function(driver) {");
		script(sb, "driver.get('http://www.google.com');");
		script(sb,
				"var element = driver.findElement(org.openqa.selenium.By.name('q'));");
		script(sb, "element.sendKeys('Done');");
		script(sb, "element.submit();");
		script(sb, "return driver.getTitle();");
		script(sb, "}");

		try {
			engine.eval(sb.toString());
			Invocable invokable = (Invocable) engine;
			System.out.println(invokable.invokeFunction("run", driver));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void cleardown() {
		driver.close();
	}

}
