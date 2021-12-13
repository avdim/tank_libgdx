package com.riseofcat.tank.play;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

abstract public class AbstractTextureObject extends AbstractObject {
public AbstractTextureObject(int x, int y, int size) {
	super(x, y, size);
}

@Override
public void draw(SpriteBatch batch, float deltaTime) {
	float rotation = textureRotation();
	int width = getTexture().getWidth();
	int height = getTexture().getHeight();
	batch.draw(getTexture(), x - width / 2, y - height / 2, width / 2, height / 2, width, height, 1, 1, rotation, 0, 0, width, height, false, false);
}

abstract protected float textureRotation();

abstract protected Texture getTexture();

}

