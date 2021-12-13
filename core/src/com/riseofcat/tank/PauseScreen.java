package com.riseofcat.tank;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
public class PauseScreen extends ATextScreen {
private final AScreen previous;
private final int level;
public PauseScreen(MainGame game, AScreen screen, int level) {
	super(game);
	this.previous = screen;
	this.level = level;
}

@Override
public String text() {
	return "Пауза\nРанд " + level + "\nКликни, чтобы продолжить";
}
@Override
public BitmapFont font() {
	return Resources.Font.normalFont();
}
@Override
public void action() {
	continueGame();
}
@Override
public void pause() {
	continueGame();
}
@Override
public void move() {

}
@Override
public void touch() {
	continueGame();
}
private void continueGame() {
	game.screen = previous;
}
}
