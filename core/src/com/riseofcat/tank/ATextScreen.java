package com.riseofcat.tank;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;

abstract public class ATextScreen extends AScreen {
final static float friendScale = 0.7f;

public ATextScreen(MainGame game) {
	super(game);
}

@Override
final public void draw(SpriteBatch batch, float deltaTime, int width, int height) {
	font().draw(batch, text(), 0, height / 2 + 80, width, Align.center, true);
	if(game.inviteFriends != null) {
		Texture friend = Resources.Textures.friend;
		batch.draw(friend, getFriendX(), getFriendY(), 0, 0, friend.getWidth(), friend.getHeight(), friendScale, friendScale, 0,0,0, friend.getWidth(), friend.getHeight(), false, false);
	}
}
@Override
public void touch(int x, int y) {
	if(game.inviteFriends != null && x > getFriendX() && y < Resources.Textures.friend.getHeight()*friendScale) {
		game.inviteFriends.call();
	} else {
		touch();
	}
}
private static int getFriendX() {
	return (int) (Gdx.graphics.getWidth() - Resources.Textures.friend.getWidth() * friendScale);
}
private static int getFriendY() {
	return (int) (Gdx.graphics.getHeight() - Resources.Textures.friend.getHeight() * friendScale);
}
abstract protected void touch();
abstract public BitmapFont font();
abstract public String text();

}
