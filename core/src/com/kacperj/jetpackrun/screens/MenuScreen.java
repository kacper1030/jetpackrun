package com.kacperj.jetpackrun.screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.kacperj.jetpackrun.JetpackRun;

public class MenuScreen extends AbstractScreen{

	private Button buttonPlay, buttonCredits, buttonExit;
	private BitmapFont font;
	
	public MenuScreen(final JetpackRun game) {
		super(game);
		init();
		buttonPlaySettings();
		
		
		showGameplayScreen();
	}

	private void buttonPlaySettings() {
		buttonPlay();
		buttonCredits();
		buttonExit();
	}

	private void buttonExit() {
		buttonExit = new Button(new ButtonStyle());
		buttonExit.setX(50);
		buttonExit.setY(450);
		buttonExit.setWidth(400);
		buttonExit.setHeight(100);
		buttonExit.setDebug(true);
		
		stage.addActor(buttonExit);
	}

	private void buttonCredits() {
		buttonCredits = new Button(new ButtonStyle());
		buttonCredits.setX(50);
		buttonCredits.setY(270);
		buttonCredits.setWidth(400);
		buttonCredits.setHeight(100);
		buttonCredits.setDebug(true);
		
		stage.addActor(buttonCredits);
	}

	private void buttonPlay() {
		buttonPlay = new Button(new ButtonStyle());
		buttonPlay.setX(50);
		buttonPlay.setY(80);
		buttonPlay.setWidth(400);
		buttonPlay.setHeight(100);
		buttonPlay.setDebug(true);
		
		stage.addActor(buttonPlay);
	}

	private void showGameplayScreen() {
		game.setScreen(new GameplayScreen(game));
	}

	private void init() {
		
	}

	@Override
	public void render(float delta) {
		super.render(delta);

		batch.begin();
		
		stage.draw();
		
		
		batch.end();

	}
	
	
}
