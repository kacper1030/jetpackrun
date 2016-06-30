package com.kacperj.jetpackrun.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.kacperj.jetpackrun.JetpackRun;
import com.kacperj.jetpackrun.gameobject.GameObject;
import com.kacperj.jetpackrun.gameobject.JumpPlayer;

public class GameplayScreen extends AbstractScreen{

	private JumpPlayer jumpPlayer;
	private GameObject playerObj;
	private Texture playerTex;
	
	private float gravity = -13;
	
	public GameplayScreen(JetpackRun game) {
		super(game);
		init();
	}
	
	private void init() {
		
		jumpPlayer = new JumpPlayer();
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

	private void update() {
		playerObj.y += jumpPlayer.jumpVelocity * Gdx.graphics.getDeltaTime();
		
		if(playerObj.y > 0){
			jumpPlayer.jumpVelocity += gravity;
		} else {
			playerObj.y = 0;
			jumpPlayer.canJump = true;
			jumpPlayer.jumpVelocity = 0;
		}
		
		movePlayer();
		
	}

	private void movePlayer() {
		if(Gdx.input.isKeyPressed(Keys.W)){
			playerObj.y += 500 * Gdx.graphics.getDeltaTime();
		}
	}

}



