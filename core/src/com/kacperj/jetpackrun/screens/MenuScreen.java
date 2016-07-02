package com.kacperj.jetpackrun.screens;

import com.badlogic.gdx.graphics.Texture;
import com.kacperj.jetpackrun.JetpackRun;

public class MenuScreen extends AbstractScreen{

	private Texture texture;
	
	public MenuScreen(final JetpackRun game) {
		super(game);
		init();
		
		showGameplayScreen();
	}

	private void showGameplayScreen() {
		game.setScreen(new GameplayScreen(game));
	}

	private void init() {
		texture = new Texture("badlogic.jpg");
	}

	@Override
	public void render(float delta) {
		super.render(delta);

		batch.begin();

		batch.draw(texture, 100, 200);

		batch.end();

	}
	
	
}
