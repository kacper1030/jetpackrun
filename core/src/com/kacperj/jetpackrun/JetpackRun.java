package com.kacperj.jetpackrun;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class JetpackRun extends Game {
	
	protected static final int HEIGHT = 700;
	protected static final  int WIDTH = 500;
	protected static final String GAME_NAME = "JetpackRun!";
	
	
	public void create () {
	}

	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
}
