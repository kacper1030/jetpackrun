package com.kacperj.jetpackrun.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.kacperj.jetpackrun.JetpackRun;

public class SplashScreen1 extends AbstractScreen {

	private Texture texture;

	public SplashScreen1(final JetpackRun game) {
		super(game);
		init();

		Timer.schedule(new Task() {

			@Override
			public void run() {
				game.setScreen(new GameplayScreen(game));
			}
		}, 2);
	}

	private void init() {
		texture = new Texture("splashimg.jpg");
	}

	@Override
	public void render(float delta) {
		super.render(delta);

		batch.begin();

		batch.draw(texture, 0, 0);

		batch.end();

	}

}
