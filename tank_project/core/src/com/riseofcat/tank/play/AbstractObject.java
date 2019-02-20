package com.riseofcat.tank.play;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Set;

abstract public class AbstractObject {
public final int size;
public int x;
public int y;

public AbstractObject(int x, int y, int size) {
	this.size = size;
	this.x = x;
	this.y = y;
}
final public boolean collide(AbstractObject obj, int objX, int objY) {
	return Math.abs(x - objX) < obj.size / 2 + size / 2 && Math.abs(y - objY) < obj.size / 2 + size / 2;
}
final public boolean collide(AbstractObject obj) {
	return collide(obj, obj.x, obj.y);
}
abstract public void draw(SpriteBatch batch, float deltaTime);
abstract public UpdateResult update(Set<AbstractObject> objects);
abstract public boolean isTank();
abstract public boolean isBoom();
abstract public boolean isBullet();
}
