package com.techkids.tram_trams_adventure.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.techkids.tram_trams_adventure.Program;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 900;
		config.height = 480;
		config.title = "Tramtram's Adventure";

		new LwjglApplication(new Program(), config);
	}
}
