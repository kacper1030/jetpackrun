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
	private Terrain terrain, terrain1;
	private JumpPlayer jumpPlayer;
	private Texture playerTex;
	private GameObject playerObj;
	private Texture terrainTexture, terrainTexture1;
	
	private GameObject obj250x80, obj50x200, obj50x50, obj80x80;
	private Texture tex250x80, tex50x200, tex50x50, tex80x80;
	
	private float gravity = -12;

	public GameplayScreen(JetpackRun game) {
		super(game);
		init();
	}

	private void init() {
		initObjects();
		initPlayerSettings();
		initTerrain();
		playMusic();
		
	}

	private void initPlayerSettings() {
		jumpPlayer = new JumpPlayer();
		playerTex = new Texture("playerTex.png");
		playerObj = new GameObject(playerTex);

		playerObj.x = 0;
		playerObj.y = 120;
		playerObj.height = playerObj.getTexture().getHeight();
		playerObj.width = playerObj.getTexture().getWidth();
	}
	
	private void initObjects() {
		initTexturesOfObjects();
		
		obj250x80 = new GameObject(tex250x80); 
		obj50x200 = new GameObject(tex50x200); 
		obj50x50 = new GameObject(tex50x50); 
		obj80x80 = new GameObject(tex80x80); 
	}

	private void initTexturesOfObjects() {
		tex250x80 = new Texture("terrainAssets/250x80.png");
		tex50x200 = new Texture("terrainAssets/50x200.png");
		tex50x50 = new Texture("terrainAssets/50x50.png");
		tex80x80 = new Texture("terrainAssets/80x80.png");
	}

	private void playMusic() {
		music = Gdx.audio.newMusic(Gdx.files.internal("soundtrack1.mp3"));
		music.play();
	}

	private void initTerrain() {
		
		initObjectsOnMap();
		
		terrainTexture = new Texture("terrainTexture.png");
		terrain = new Terrain(terrainTexture);

		terrain.x = 0;
		terrain.y = 20;
		terrain.width = terrain.getTexture().getWidth();
		terrain.height = terrain.getTexture().getHeight();
		
		terrainTexture1 = new Texture("terrainTexture.png");
		terrain1 = new Terrain(terrainTexture1);

		terrain1.x = 500;
		terrain1.y = 20;
		terrain1.width = terrain1.getTexture().getWidth();
		terrain1.height = terrain1.getTexture().getHeight();
	}
	
	private void initObjectsOnMap() {
		
		prop250x80();
		prop50x200();
		prop50x50();
		prop80x80();

	}

	private void prop80x80() {
		obj80x80.height = obj80x80.getTexture().getHeight();
		obj80x80.width = obj80x80.getTexture().getHeight();
		obj80x80.x = 700;
		obj80x80.y = 250;
	}

	private void prop50x50() {
		obj50x50.height = obj50x50.getTexture().getHeight();
		obj50x50.width = obj50x50.getTexture().getHeight();
		obj50x50.x = 800;
		obj50x50.y = 300;
	}

	private void prop50x200() {
		obj50x200.height = obj250x80.getTexture().getHeight();
		obj50x200.width = obj250x80.getTexture().getHeight();
		obj50x200.x = 500;
		obj50x200.y = 200;
	}

	private void prop250x80() {
		obj250x80.height = obj250x80.getTexture().getHeight();
		obj250x80.width = obj250x80.getTexture().getHeight();
		obj250x80.x = 300;
		obj250x80.y = 100;
	}

	@Override
	public void render(float delta) {
		super.render(delta);

		update();

		cameraOnPlayer();

		batch.begin();
		
		
		batch.draw(obj80x80.getTexture(), obj80x80.x, obj80x80.y);
		batch.draw(obj50x50.getTexture(), obj50x50.x, obj50x50.y);
		batch.draw(obj50x200.getTexture(), obj50x200.x, obj50x200.y);
		batch.draw(obj250x80.getTexture(), obj250x80.x, obj250x80.y);
		batch.draw(playerObj.getTexture(), playerObj.x, playerObj.y);
		batch.draw(terrain.getTexture(), terrain.x, terrain.y);
		
		drawAllTerrains();

		batch.end();

	}

	private void drawAllTerrains() {
		batch.draw(terrain.getTexture(), 500, 20);
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
		if (playerObj.overlaps(terrain1)) {
			playerObj.y = 100;
		}
		
		colisionProps();
		
	}

	private void colisionProps() {
		if (playerObj.overlaps(obj250x80)){
			playerObj.y = 180;
		}
	}

	private void movePlayer() {
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			playerObj.y += 400 * Gdx.graphics.getDeltaTime();
		}
		if (Gdx.input.isKeyPressed(Keys.S)) {
			playerObj.y -= 200 * Gdx.graphics.getDeltaTime();
		}
		if (Gdx.input.isKeyPressed(Keys.A)) {
			playerObj.x -= 200 * Gdx.graphics.getDeltaTime();
		}
		if (Gdx.input.isKeyPressed(Keys.D)) {
			playerObj.x += 300 * Gdx.graphics.getDeltaTime();
		}
	}

}
