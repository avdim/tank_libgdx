package com.riseofcat.tank.play;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import java.util.Set;

public class Player extends Pilot {
Direction justPressedDirection = null;

@Override
public void update(Set<AbstractObject> objects) {
	if(Gdx.input.isKeyJustPressed(Input.Keys.W) || Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
		justPressedDirection = Direction.up;
	} else if(Gdx.input.isKeyJustPressed(Input.Keys.S) || Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
		justPressedDirection = Direction.down;
	} else if(Gdx.input.isKeyJustPressed(Input.Keys.A) || Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
		justPressedDirection = Direction.left;
	} else if(Gdx.input.isKeyJustPressed(Input.Keys.D) || Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
		justPressedDirection = Direction.right;
	}
}

@Override
public Direction choiceDirection(Set<AbstractObject> objects) {
	Direction direction = null;
	if(Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)) {
		direction = Direction.up;
	} else if(Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
		direction = Direction.down;
	} else if(Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
		direction = Direction.left;
	} else if(Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
		direction = Direction.right;
	}
	if(direction == null) {
		direction = justPressedDirection;
	}
	justPressedDirection = null;
	return direction;
}

@Override
public boolean choiceFire(Set<AbstractObject> objects) {
	return Gdx.input.isKeyPressed(Input.Keys.SPACE) || Gdx.input.isKeyPressed(Input.Keys.ENTER);
}
}
