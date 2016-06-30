package com.kacperj.jetpackrun;
import com.kacperj.jetpackrun.gameobject.GameObject;
import com.kacperj.jetpackrun.screens.GameplayScreen;
import com.kacperj.jetpackrun.screens.SplashScreen1;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;

public class JetpackRun extends Game {
	
	private GameObject gameobj;
	private Texture tex;
	
	public static final int HEIGHT = 700;
	public static final  int WIDTH = 500;
	public static final String GAME_NAME = "JetpackRun!";
	
	public void create () {
		this.setScreen(new SplashScreen1(this));		
	}

	
}
