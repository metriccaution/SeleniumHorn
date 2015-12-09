package com.github.metriccaution.seleniumhorn.runner;

public interface SeleniumHornRunner {
	public void before();

	public void run();

	public void cleardown();
}
