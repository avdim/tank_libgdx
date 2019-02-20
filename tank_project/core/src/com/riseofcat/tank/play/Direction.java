package com.riseofcat.tank.play;

import com.riseofcat.tank.Lib;
public enum Direction {
	up(Axis.y, 0, 1),
	down(Axis.y, 0, -1),
	left(Axis.x, -1, 0),
	right(Axis.x, 1, 0);
public final Axis axis;
public final int deltaX;
public final int deltaY;

Direction(Axis axis, int deltaX, int deltaY) {
	this.axis = axis;
	this.deltaX = deltaX;
	this.deltaY = deltaY;
}

public static Direction random() {
	Direction[] all = values();
	return all[Lib.random(0, all.length - 1)];
}

public enum Axis {
	x,
	y
}
}
