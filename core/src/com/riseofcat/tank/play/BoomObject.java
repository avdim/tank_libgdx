package com.riseofcat.tank.play;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.riseofcat.tank.Resources;

import java.util.Set;

public class BoomObject extends AbstractObject {
static final float DURATION = 1.0f;
static final int FRAME_ROWS = 1;
static final int FRAME_COLS = 29;
static final Animation<TextureRegion> explosionAnimation;
private final AbstractObject explosionObject;
private float stateTime = 0;
static {
	final Texture boomList = Resources.Textures.boomAnimation;
	TextureRegion[][] tmp = TextureRegion.split(boomList, boomList.getWidth() / FRAME_COLS, boomList.getHeight() / FRAME_ROWS);
	TextureRegion[] explosionFrames = new TextureRegion[FRAME_COLS];
	int index = 0;
	for(int i = 0; i < FRAME_COLS; i++) {
		explosionFrames[index++] = tmp[0][i];
	}
	explosionAnimation = new Animation<TextureRegion>(DURATION / FRAME_COLS / FRAME_ROWS, explosionFrames);
}

public BoomObject(AbstractObject object) {
	super(object.x, object.y, object.size);
	this.explosionObject = object;
}

@Override
public void draw(SpriteBatch batch, float deltaTime) {
	stateTime += deltaTime;
	explosionObject.draw(batch, deltaTime);
	TextureRegion frame = explosionAnimation.getKeyFrame(stateTime, true);
	batch.draw(frame, explosionObject.x - explosionObject.size / 4, explosionObject.y - explosionObject.size / 4, 0, 0, frame.getRegionWidth(), frame.getRegionHeight(), 1, 1, 0);
}

@Override
public UpdateResult update(Set<AbstractObject> objects) {
	UpdateResult result = new UpdateResult();
	if(stateTime > DURATION) {
		result.remove(this);
	}
	return result;
}
@Override
public boolean isTank() {
	return false;
}
@Override
public boolean isBoom() {
	return true;
}
@Override
public boolean isBullet() {
	return false;
}
}
