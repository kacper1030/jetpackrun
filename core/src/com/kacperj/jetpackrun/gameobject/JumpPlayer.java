package com.kacperj.jetpackrun.gameobject;

import com.badlogic.gdx.math.Rectangle;

public class JumpPlayer extends Rectangle{

	public boolean canJump = true;
	
	public float jumpVelocity;
	
	public void Jump(){
		if(canJump && jumpVelocity >= 0){
			jumpVelocity += 500;
			canJump = false;
		}
	}
	
}

