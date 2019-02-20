package com.riseofcat.tank;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.riseofcat.tank.play.PlayScreen;

public class StartScreen extends ATextScreen {
private final int level;

public StartScreen(MainGame game, int level) {
	super(game);
	this.level = level;
}
@Override
public String text() {
	return "Раунд " + level + "\n Кликни, чтобы начать";
}
@Override
public BitmapFont font() {
	return Resources.Font.normalFont();
}
@Override
public void action() {
	begin();
}
@Override
public void pause() {

}
@Override
public void move() {

}
private void begin() {
	game.screen = new PlayScreen(game, level);
}
@Override
public void touch() {
	begin();
}
}
