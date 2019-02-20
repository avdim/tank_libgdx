package com.riseofcat.tank.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.riseofcat.tank.ICallback;
import com.riseofcat.tank.MainGame;

public class DesktopLauncher {
public static void main(String[] arg) {
	LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
	config.title = "Tank Hardcore";
	config.width = MainGame.WORLD_WIDTH;
	config.height = MainGame.WORLD_HEIGHT;
	config.resizable = false;
	new LwjglApplication(new MainGame(new ICallback() {
		@Override
		public void call() {
			int a = 1;
		}
	}), config);
}
}

