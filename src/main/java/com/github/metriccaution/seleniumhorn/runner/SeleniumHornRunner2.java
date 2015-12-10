package com.github.metriccaution.seleniumhorn.runner;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.inject.Inject;
import javax.script.Invocable;
import javax.script.ScriptEngine;

import org.openqa.selenium.WebDriver;

import com.github.metriccaution.seleniumhorn.scripting.ScriptEngineBuilder;
import com.github.metriccaution.seleniumhorn.webdriver.WebdriverBuilder;

public class SeleniumHornRunner2 implements SeleniumHornRunner {

	private final ScriptEngine engine;
	private final WebDriver driver;

	@Inject
	public SeleniumHornRunner2(final ScriptEngineBuilder seb,
			final WebdriverBuilder web) {
		engine = seb.build();
		driver = web.build();
	}

	@Override
	public void before() {
	}

	@Override
	public void run() {
		try (final BufferedReader reader = new BufferedReader(
				new InputStreamReader(this.getClass().getClassLoader()
						.getResourceAsStream("webdriver.js")))) {

			final StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}

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
