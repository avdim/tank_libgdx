package com.riseofcat.tank;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGame implements ApplicationListener {
public static final int TILE_SIZE = 32;
public static final int X_TILES = 25;
public static final int Y_TILES = 20;
public static final int WORLD_WIDTH = X_TILES * TILE_SIZE;
public static final int WORLD_HEIGHT = Y_TILES * TILE_SIZE;
public final ICallback inviteFriends;

private SpriteBatch batch;
public AScreen screen = new StartScreen(this, 1);
public MainGame(ICallback inviteFriends) {
	this.inviteFriends = inviteFriends;
}
@Override
public void create() {
	batch = new SpriteBatch();
}

@Override
public void render() {
	if(Gdx.input.justTouched()) {
		screen.touch(Gdx.input.getX(), Gdx.input.getY());
	} else if(Gdx.input.isKeyJustPressed(Input.Keys.BACKSPACE) || Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
		screen.pause();
		return;
	} else if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
		screen.action();
	} else if(Gdx.input.isKeyJustPressed(Input.Keys.W) ||
					Gdx.input.isKeyJustPressed(Input.Keys.S) ||
					Gdx.input.isKeyJustPressed(Input.Keys.A) ||
					Gdx.input.isKeyJustPressed(Input.Keys.D) ||
					Gdx.input.isKeyJustPressed(Input.Keys.UP) ||
					Gdx.input.isKeyJustPressed(Input.Keys.DOWN) ||
					Gdx.input.isKeyJustPressed(Input.Keys.LEFT) ||
					Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
		screen.move();
	} else if(Gdx.input.isKeyJustPressed(Input.Keys.P)) {
		screen.pause();
	} else if(Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
//		screen.pause();
	}
	int width = Gdx.graphics.getWidth();
	int height = Gdx.graphics.getHeight();
	batch.begin();
	Texture background = Resources.Textures.background;
	if(false) {
		batch.draw(background, 0, 0, 0, 0, width, height, 1, 1, 0, 0, 0, background.getWidth(), background.getHeight(), false, false);
	}
	batch.draw(background, 0, 0, 0, 0, width, height);
	screen.draw(batch, Gdx.graphics.getDeltaTime(), width, height);
	batch.end();
}

@Override
public void resize(int width, int height) {

}

@Override
public void pause() {

}

@Override
public void resume() {

}

@Override
public void dispose() {

}

}