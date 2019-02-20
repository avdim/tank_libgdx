package com.riseofcat.tank.play;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.riseofcat.tank.AScreen;
import com.riseofcat.tank.Lib;
import com.riseofcat.tank.LoseScreen;
import com.riseofcat.tank.MainGame;
import com.riseofcat.tank.PauseScreen;
import com.riseofcat.tank.WinScreen;

import java.util.HashSet;
import java.util.Set;

public class PlayScreen extends AScreen {
public static final int INCREASE_ENEMIES = 5;
public static final int BLOCK_ATTEMPTS = 120;
private final Set<AbstractObject> objects = new HashSet<AbstractObject>();
private final int level;

public PlayScreen(MainGame game, int level) {
	super(game);
	this.level = level;
	objects.add(new Tank(randomX(), randomY(), Team.green, true, Direction.random(), new Player()));
	for(int i = 0; i < level * INCREASE_ENEMIES; i++) {
		Tank tank;
		do {
			tank = new Tank(randomX(), randomY(), Team.red, false, Direction.random(), new Bot());
		} while(collide(tank));
		objects.add(tank);
	}
	for(int i = 0; i < BLOCK_ATTEMPTS; i++) {
		int x = randomX();
		int y = randomY();
		Block block = new Block(x, y);
		if(!collide(block)) {
			objects.add(block);
			objects.add(new Block(x - MainGame.TILE_SIZE, y));
			objects.add(new Block(x, y - MainGame.TILE_SIZE));
			objects.add(new Block(x - MainGame.TILE_SIZE, y - MainGame.TILE_SIZE));
		}
//			Block block = new Block(Lib.random(0, MainGame.X_TILES - 1) * MainGame.TILE_SIZE, Lib.random(0, MainGame.Y_TILES - 1) * MainGame.TILE_SIZE);
	}

}

private boolean whoWin(Team team) {
	for(AbstractObject object : objects) {
		if(object.isTank()) {
			if(((Tank) object).team != team) {
				return false;
			}
		}
	}
	return true;
}

@Override
public void draw(SpriteBatch batch, float deltaTime, int width, int height) {
	update();
	for(AbstractObject object : objects) {
		if(object instanceof Bullet) {
			object.draw(batch, deltaTime);
		}
	}
	for(AbstractObject object : objects) {
		if(!(object instanceof Bullet)) {
			object.draw(batch, deltaTime);
		}
	}
}

private void update() {
	UpdateResult result = new UpdateResult();
	for(AbstractObject current : objects) {
//		Set<AbstractObject> excludeCurrentObject = new HashSet<AbstractObject>(objects);
//		excludeCurrentObject.remove(current);
		UpdateResult currentResult = current.update(objects/*excludeCurrentObject*/);
		if(currentResult != null) {
			result.added.addAll(currentResult.added);
			result.removed.addAll(currentResult.removed);
		}
	}
	objects.removeAll(result.removed);
	objects.addAll(result.added);
	for(AbstractObject obj : result.removed) {
		if(obj.isTank()) {
			Tank tank = (Tank) obj;
			objects.add(new BoomObject(tank));
		}
	}
	if(!boomExists()) {
		if(whoWin(Team.red)) {
			game.screen = new LoseScreen(game, level);
		} else if(whoWin(Team.green)) {
			game.screen = new WinScreen(game, level);
		}
	}
}

private boolean boomExists() {
	for(AbstractObject object : objects) {
		if(object.isBoom()) {
			return true;
		}
	}
	return false;
}

private boolean collide(AbstractObject obj) {
	for(AbstractObject object : objects) {
		if(object != obj && object.collide(obj)) {
			return true;
		}
	}
	return false;
}
public static boolean movedOut(AbstractObject obj, int objX, int objY) {
	return objX - obj.size / 2 < 0 ||
					objX + obj.size / 2 > MainGame.WORLD_WIDTH ||
					objY - obj.size / 2 < 0 ||
					objY + obj.size / 2 > MainGame.WORLD_HEIGHT;
}
public static boolean movedOut(AbstractObject obj) {
	return movedOut(obj, obj.x, obj.y);
}
private static int randomX() {
	return (Lib.random(0, MainGame.X_TILES / 2 - 1) * 2 + 1) * MainGame.TILE_SIZE;
}
private static int randomY() {
	return (Lib.random(0, MainGame.Y_TILES / 2 - 1) * 2 + 1) * MainGame.TILE_SIZE;
}
@Override
public void action() {
}
@Override
public void move() {
}
@Override
public void pause() {
	pauseGame();
}
@Override
public void touch(int x, int y) {
	pauseGame();
}

private void pauseGame() {
	game.screen = new PauseScreen(game, this, level);
}

}
