package com.riseofcat.tank;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.riseofcat.tank.play.PlayScreen;

public class LoseScreen extends ATextScreen {
private final int level;

public LoseScreen(MainGame game, int level) {
	super(game);
	this.level = level;
}
@Override
public String text() {
	return "Поражение\nРаунд " + level + "\nКликни, чтобы переиграть";
}
@Override
public BitmapFont font() {
	return Resources.Font.loseFont();
}
@Override
public void action() {
	regame();
}
@Override
public void pause() {

}
@Override
public void touch() {
	regame();
}
@Override
public void move() {

}
private void regame() {
	game.screen = new PlayScreen(game, level);
}
}
