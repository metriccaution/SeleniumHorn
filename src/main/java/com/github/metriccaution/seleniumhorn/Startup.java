package com.github.metriccaution.seleniumhorn;

import com.github.metriccaution.seleniumhorn.runner.SeleniumHornRunner;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Startup {

	public static void main(String[] args) throws Exception {
		Injector injector = Guice.createInjector(new SeleniumHornModule());
		SeleniumHornRunner runner = injector
				.getInstance(SeleniumHornRunner.class);

		try {
			runner.before();
			runner.run();
		} catch (Exception e) {
			e.printStackTrace();
		}

		runner.cleardown();
	}
}
