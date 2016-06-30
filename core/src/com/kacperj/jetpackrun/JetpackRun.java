package com.kacperj.jetpackrun;
import com.kacperj.jetpackrun.screens.SplashScreen1;

import com.badlogic.gdx.Game;

public class JetpackRun extends Game {
	
	public static final int HEIGHT = 700;
	public static final  int WIDTH = 500;
	public static final String GAME_NAME = "JetpackRun!";
	
	public void create () {
		this.setScreen(new SplashScreen1(this));
	}
}
