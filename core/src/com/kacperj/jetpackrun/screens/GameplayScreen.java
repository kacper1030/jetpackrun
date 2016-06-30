package com.kacperj.jetpackrun.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.kacperj.jetpackrun.JetpackRun;
import com.kacperj.jetpackrun.gameobject.GameObject;
import com.kacperj.jetpackrun.gameobject.JumpPlayer;
import com.kacperj.jetpackrun.utilities.Terrain;

public class GameplayScreen extends AbstractScreen {

	private Music music;
	private Terrain terrain;
	private JumpPlayer jumpPlayer;
	private Texture playerTex;
	private GameObject playerObj;
	private Texture terrainTexture;

	private float gravity = -12;

	public GameplayScreen(JetpackRun game) {
		super(game);
		init();
	}

	private void init() {
		initTerrain();
		playMusic();
		initPlayerSettings();
	}

	private void initPlayerSettings() {
		jumpPlayer = new JumpPlayer();
		playerTex = new Texture("badlogic.jpg");
		playerObj = new GameObject(playerTex);

		playerObj.x = 0;
		playerObj.y = 120;
		playerObj.height = playerObj.getTexture().getHeight();
		playerObj.width = playerObj.getTexture().getWidth();
	}

	private void playMusic() {
		music = Gdx.audio.newMusic(Gdx.files.internal("soundtrack1.mp3"));
		music.play();
	}

	private void initTerrain() {
		terrainTexture = new Texture("terrainTexture.png");
		terrain = new Terrain(terrainTexture);

		terrain.x = 0;
		terrain.y = 20;
		terrain.width = terrain.getTexture().getWidth();
		terrain.height = terrain.getTexture().getHeight();
	}

	@Override
	public void render(float delta) {
		super.render(delta);

		update();

		cameraOnPlayer();

		batch.begin();

		batch.draw(playerObj.getTexture(), playerObj.x, playerObj.y);
		batch.draw(terrain.getTexture(), terrain.x, terrain.y);

		batch.end();

	}

	private void cameraOnPlayer() {
		cam.position.set(playerObj.x + 150, playerObj.y + 200, 0);
	}

	private void update() {
		setupWorld();
		colisionTerrain();
		movePlayer();

	}

	private void setupWorld() {
		playerObj.y += jumpPlayer.jumpVelocity * Gdx.graphics.getDeltaTime();

		if (playerObj.y > 100) {
			jumpPlayer.jumpVelocity += gravity;
		} else {
			playerObj.y = 0;
			jumpPlayer.canJump = true;
			jumpPlayer.jumpVelocity = 0;
		}

	}

	private void colisionTerrain() {
		if (playerObj.overlaps(terrain)) {
			playerObj.y = 100;
		}
	}

	private void movePlayer() {
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			playerObj.y += 500 * Gdx.graphics.getDeltaTime();
		}
		if (Gdx.input.isKeyPressed(Keys.S)) {
			playerObj.y -= 100 * Gdx.graphics.getDeltaTime();
		}
		if (Gdx.input.isKeyPressed(Keys.A)) {
			playerObj.x -= 100 * Gdx.graphics.getDeltaTime();
		}
		if (Gdx.input.isKeyPressed(Keys.D)) {
			playerObj.x += 100 * Gdx.graphics.getDeltaTime();
		}
	}

}
