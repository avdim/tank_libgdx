package com.riseofcat.tank.play;

import com.badlogic.gdx.graphics.Texture;
import com.riseofcat.tank.MainGame;
import com.riseofcat.tank.Resources;

import java.util.Set;

public class Bullet extends AbstractTextureObject {
private final Direction direction;
public final Tank parent;
public static final int SPEED = 3;

public Bullet(int x, int y, Direction direction, Tank parent) {
	super(x, y, MainGame.TILE_SIZE / 2);
	this.direction = direction;
	this.parent = parent;
}

@Override
public UpdateResult update(Set<AbstractObject> objects) {
	UpdateResult result = new UpdateResult();
	x += direction.deltaX * SPEED;
	y += direction.deltaY * SPEED;
	for(AbstractObject obj : objects) {
		if(obj == this) {
			continue;
		}
		if(parent != obj && Math.abs(obj.x - x) < obj.size / 2 + size / 2 && Math.abs(obj.y - y) < obj.size / 2 + size / 2) {
			result.remove(this);
			if(obj.isTank()) {
				if(((Tank) obj).team == parent.team) {

				} else {
					result.remove(obj);
				}
			} else if(obj instanceof BoomObject) {
			} else {
				result.remove(obj);
			}
		}
	}
	if(PlayScreen.movedOut(this)) {
		result.remove(this);
	}
	return result;
}

@Override
protected float textureRotation() {
	switch(direction) {
		case up:
			return 0;
		case down:
			return 180;
		case left:
			return 90;
		case right:
			return 270;
	}
	return 0;
}

@Override
protected Texture getTexture() {
	return Resources.Textures.bullet;
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
	return true;
}
}
