package com.kacperj.jetpackrun.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.kacperj.jetpackrun.JetpackRun;

public class DesktopLauncher extends JetpackRun {

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = GAME_NAME;
		config.height = HEIGHT;
		config.width = WIDTH;
		
		config.resizable = false;
		
		new LwjglApplication(new JetpackRun(), config);
	}
}
