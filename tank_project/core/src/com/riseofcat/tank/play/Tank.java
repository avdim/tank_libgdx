package com.riseofcat.tank.play;

import com.badlogic.gdx.graphics.Texture;
import com.riseofcat.tank.MainGame;
import com.riseofcat.tank.Resources;

import java.util.Set;

public class Tank extends AbstractTextureObject {
public static final int SPEED = 1;
public static final int RELOAD = 30;
public final Team team;
private final Pilot pilot;
private final boolean playSounds;
private int reload = 60;
private Direction moveDirection = null;
private Direction gunDirection = Direction.down;

public Tank(int x, int y, Team team, boolean sound, Direction direction, Pilot pilot) {
	super(x, y, MainGame.TILE_SIZE * 2);
	this.team = team;
	this.pilot = pilot;
	this.pilot.setTank(this);
	this.playSounds = sound;
	this.gunDirection = direction;
}

@Override
final public UpdateResult update(Set<AbstractObject> objects) {
	UpdateResult result = new UpdateResult();
	pilot.update(objects);
	if(moveDirection != null) {
		if(x % MainGame.TILE_SIZE == 0 && moveDirection.axis == Direction.Axis.x) {
			moveDirection = null;
		} else if(y % MainGame.TILE_SIZE == 0 && moveDirection.axis == Direction.Axis.y) {
			moveDirection = null;
		}
	}
	if(moveDirection == null) {
		moveDirection = pilot.choiceDirection(objects);
	}
	if(moveDirection != null) {
		gunDirection = moveDirection;
		int newX = x + moveDirection.deltaX * SPEED;
		int newY = y + moveDirection.deltaY * SPEED;
		if(PlayScreen.movedOut(this, newX, newY)) {
			moveDirection = null;
		} else {
			for(AbstractObject obj : objects) {
				if(obj == this) {
					continue;
				}
				if(obj.isBullet()) {
					continue;
				}
				if(obj.collide(this, newX, newY)) {
					moveDirection = null;
					break;
				}
			}
		}
		if(moveDirection != null) {
			x = newX;
			y = newY;
		}
	}
	if(reload == 0) {
		if(pilot.choiceFire(objects)) {
			result.add(new Bullet(x, y, gunDirection, this));
			reload = RELOAD;
			if(playSounds) {

			}
		}
	} else {
		reload--;
	}
	if(playSounds) {
		if(moveDirection != null) {

		} else {
			
		}
	}
	return result;
}

@Override
protected float textureRotation() {
	switch(gunDirection) {
		case up:
			return 180;
		case down:
			return 0;
		case left:
			return 270;
		case right:
			return 90;
	}
	return 0;
}

@Override
protected Texture getTexture() {
	switch(team) {
		case green:
			return Resources.Textures.green;
		case red:
			return Resources.Textures.red;
	}
	return null;
}
@Override
public boolean isTank() {
	return true;
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
