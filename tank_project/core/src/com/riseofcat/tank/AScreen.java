package com.riseofcat.tank;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class AScreen {
public final MainGame game;

public AScreen(MainGame game) {
	this.game = game;
}

public abstract void draw(SpriteBatch batch, float deltaTime, int width, int height);
abstract public void action();
abstract public void pause();
abstract public void move();
abstract public void touch(int x, int y);
}
