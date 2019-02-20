package com.riseofcat.tank.play;

import com.badlogic.gdx.graphics.Texture;
import com.riseofcat.tank.MainGame;
import com.riseofcat.tank.Resources;

import java.util.Set;

public class Block extends AbstractTextureObject {
public Block(int x, int y) {
	super(MainGame.TILE_SIZE / 2 + x, MainGame.TILE_SIZE / 2 + y, MainGame.TILE_SIZE);
}
@Override
public UpdateResult update(Set<AbstractObject> objects) {
	return null;
}
@Override
protected float textureRotation() {
	return 0;
}
@Override
protected Texture getTexture() {
	return Resources.Textures.block;
}
@Override
public boolean isTank() {
	return false;
}
@Override
public boolean isBoom() {
	return false;
}
@Override
public boolean isBullet() {
	return false;
}
}
