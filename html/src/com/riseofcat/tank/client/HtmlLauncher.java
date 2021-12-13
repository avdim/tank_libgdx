package com.riseofcat.tank.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.riseofcat.tank.ICallback;
import com.riseofcat.tank.MainGame;

public class HtmlLauncher extends GwtApplication {

@Override
public GwtApplicationConfiguration getConfig() {
	GwtApplicationConfiguration conf = new GwtApplicationConfiguration(MainGame.WORLD_WIDTH, MainGame.WORLD_HEIGHT);
	conf.preferFlash = false;
	return conf;
}

@Override
public ApplicationListener createApplicationListener() {
	return new MainGame(friendsAvailable()?new ICallback() {
		@Override
		public void call() {
			inviteFriends();
		}
	} : null);
}
public static native boolean friendsAvailable() /*-{
			return $wnd.friendsAvailable;
    }-*/;

public static native void inviteFriends() /*-{
      return $wnd.inviteFriends();
    }-*/;
}