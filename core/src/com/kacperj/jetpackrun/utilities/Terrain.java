package com.kacperj.jetpackrun.utilities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Terrain extends Rectangle {
	
	private Texture terrainTexture;
	
	public Terrain(Texture terrainTexture){
		this.terrainTexture = terrainTexture;
	}
	public Texture getTexture(){
		return terrainTexture;
	}
	
}
