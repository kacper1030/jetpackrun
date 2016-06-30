package com.kacperj.jetpackrun;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class JetpackRun extends Game {
	
	protected final static int HEIGHT = 700;
	protected final static int WIDTH = 500;
	protected final static String GAME_NAME = "JetpackRun!";
	
	
	public void create () {
	}

	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
}
