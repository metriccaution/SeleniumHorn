package com.github.metriccaution.seleniumhorn.scripting;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ScriptEngineBuilderImpl implements ScriptEngineBuilder {

	final private ScriptEngineManager engineManager = new ScriptEngineManager();

	public ScriptEngine build() {
		return engineManager.getEngineByName("nashorn");
	}
}
