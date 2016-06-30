package com.kacperj.jetpackrun.screens;

import com.badlogic.gdx.graphics.Texture;
import com.kacperj.jetpackrun.JetpackRun;
import com.kacperj.jetpackrun.gameobject.GameObject;

public class GameplayScreen extends AbstractScreen{

	private GameObject playerObj;
	private Texture playerTex;
	public GameplayScreen(JetpackRun game) {
		super(game);
		init();
	}
	
	private void init() {

		playerTex = new Texture("badlogic.jpg");
		playerObj = new GameObject(playerTex);
		
		playerObj.x = 0;
		playerObj.y = 0;
		playerObj.height = playerObj.getTexture().getHeight();
		playerObj.width = playerObj.getTexture().getWidth();
	}
	@Override
	public void render(float delta) {
		super.render(delta);
		
		update();
		
		batch.begin();
		
		batch.draw(playerObj.getTexture(), playerObj.x, playerObj.y);
		
		batch.end();
		
	}
	
	

}
