package com.riseofcat.tank;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.riseofcat.tank.play.PlayScreen;

public class WinScreen extends ATextScreen {
private final int level;

public WinScreen(MainGame game, int level) {
	super(game);
	this.level = level;
}
@Override
public BitmapFont font() {
	return Resources.Font.winFont();
}
@Override
public String text() {
	return "Победа\nРаунд " + (level + 1) + "\nКликни, чтобы начать";
}
@Override
public void action() {
	nextLevel();
}

@Override
public void pause() {
	nextLevel();
}
@Override
public void move() {

}

@Override
public void touch() {
	nextLevel();
}

private void nextLevel() {
	game.screen = new PlayScreen(game, level + 1);
}
}
