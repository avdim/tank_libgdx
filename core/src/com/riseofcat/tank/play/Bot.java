package com.riseofcat.tank.play;

import com.riseofcat.tank.Lib;

import java.util.Set;

public class Bot extends Pilot {
public static final int MAX_FIX_DIRECTION = 5;
private int fixDirection = 0;
private Direction direction = Direction.random();
@Override
public void update(Set<AbstractObject> objects) {

}
@Override
public boolean choiceFire(Set<AbstractObject> objects) {
//	return false;
	return Math.random() < 0.01;
}
@Override
public Direction choiceDirection(Set<AbstractObject> objects) {
	if(fixDirection <= 0) {
		direction = Direction.random();
		fixDirection = Lib.random(1, MAX_FIX_DIRECTION);
	}
	fixDirection--;
	return direction;
}
}
