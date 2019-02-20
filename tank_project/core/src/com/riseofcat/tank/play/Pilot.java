package com.riseofcat.tank.play;

import java.util.Set;

abstract public class Pilot {
protected Tank tank;

public void setTank(Tank tank) {
	this.tank = tank;
}

public abstract void update(Set<AbstractObject> objects);

public abstract Direction choiceDirection(Set<AbstractObject> objects);

public abstract boolean choiceFire(Set<AbstractObject> objects);
}
