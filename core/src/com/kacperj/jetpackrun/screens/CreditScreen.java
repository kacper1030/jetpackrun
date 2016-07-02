package com.kacperj.jetpackrun.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.kacperj.jetpackrun.JetpackRun;

public class CreditScreen extends AbstractScreen{

	private BitmapFont font;
	
	public CreditScreen(JetpackRun game) {
		super(game);
		init();
		
	}

	private void init() {
		font = new BitmapFont();
		font.setColor(Color.SALMON);
		
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		batch.begin();
		
		font.draw(batch, "Author: Kacper Jakobczak", 150, 400);
		
		batch.end();
		
	}
	@Override
	public void dispose() {
		super.dispose();
		font.dispose();
	}
	
	

}
