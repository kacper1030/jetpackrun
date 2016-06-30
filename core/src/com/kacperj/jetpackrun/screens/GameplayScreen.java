package com.kacperj.jetpackrun.screens;

import com.badlogic.gdx.graphics.Texture;
import com.kacperj.jetpackrun.JetpackRun;
import com.kacperj.jetpackrun.gameobject.GameObject;

public class GameplayScreen extends AbstractScreen{

	private GameObject go;
	private Texture tex;
	public GameplayScreen(JetpackRun game) {
		super(game);
		init();
	}
	
	private void init() {

		tex = new Texture("badlogic.jpg");
		go = new GameObject(tex);
		
		go.x = 0;
		go.y = 0;
	}
	@Override
	public void render(float delta) {
		super.render(delta);
		
		batch.begin();
		
		batch.draw(go.getTexture(), go.x, go.y);
		
		batch.end();
		
	}
	

}
