package com.kacperj.jetpackrun.desktop.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.kacperj.jetpackrun.JetpackRun;

public abstract class AbstractScreen implements Screen {
	
	protected Stage stage;
	private OrthographicCamera cam;
	protected SpriteBatch batch;
	private JetpackRun game;
	
	public AbstractScreen(JetpackRun game){
		this.game = game;
		createCamera();
		stage = new Stage(new StretchViewport(JetpackRun.WIDTH,JetpackRun.HEIGHT, cam));
		batch = new SpriteBatch();
		Gdx.input.setInputProcessor(stage);
	}

	private void createCamera() {
		cam = new OrthographicCamera();
		cam.setToOrtho(false, JetpackRun.WIDTH, JetpackRun.HEIGHT);
		cam.update();
	}
	@Override
	public void render(float delta) {
		clearScreen();
		cam.update();
		batch.setProjectionMatrix(cam.combined);
	}

	private void clearScreen() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}

	@Override
	public void show() {}

	@Override
	public void resize(int width, int height) {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void hide() {}

	@Override
	public void dispose() {
		game.dispose();
		
	}
	
}
