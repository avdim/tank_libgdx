package com.riseofcat.tank.play;

import java.util.HashSet;
import java.util.Set;

public class UpdateResult {
public final Set<AbstractObject> removed = new HashSet<AbstractObject>();
public final Set<AbstractObject> added = new HashSet<AbstractObject>();

public void add(AbstractObject obj) {
	added.add(obj);
}

public void remove(AbstractObject obj) {
	removed.add(obj);
}
}
