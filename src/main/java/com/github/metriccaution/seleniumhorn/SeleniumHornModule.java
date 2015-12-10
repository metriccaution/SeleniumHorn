package com.github.metriccaution.seleniumhorn;

import com.github.metriccaution.seleniumhorn.runner.SeleniumHornRunner;
import com.github.metriccaution.seleniumhorn.runner.SeleniumHornRunner2;
import com.github.metriccaution.seleniumhorn.scripting.ScriptEngineBuilder;
import com.github.metriccaution.seleniumhorn.scripting.ScriptEngineBuilderImpl;
import com.github.metriccaution.seleniumhorn.webdriver.FirefoxWebdriverBuilder;
import com.github.metriccaution.seleniumhorn.webdriver.WebdriverBuilder;
import com.google.inject.AbstractModule;

public class SeleniumHornModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(ScriptEngineBuilder.class).to(ScriptEngineBuilderImpl.class);
		bind(WebdriverBuilder.class).to(FirefoxWebdriverBuilder.class);
		bind(SeleniumHornRunner.class).to(SeleniumHornRunner2.class);
	}

}
