package com.techkids.tram_trams_adventure.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.techkids.tram_trams_adventure.Program;
import com.techkids.tram_trams_adventure.scenes.HUD;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;

public class PlayScreen implements Screen {
    private Program game;
    //private HUD hud;
    private OrthographicCamera gameCam;
    private Viewport viewport;

    private TiledMap mapLevel1;
    private OrthogonalTiledMapRenderer renderer;
    private TmxMapLoader mapLoader;


    public PlayScreen(Program game) {
        this.game = game;
        gameCam = new OrthographicCamera();
        viewport = new FitViewport(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, gameCam); //setup cach ma view se hien thi
        // hud = new HUD(game.batch);

        mapLoader = new TmxMapLoader();
        mapLevel1 = mapLoader.load("res/bindMap/map/map.tmx");
        renderer = new OrthogonalTiledMapRenderer(mapLevel1, game.batch);
        gameCam.position.set(225, 360, 0);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        renderer.render();
//        game.batch.setProjectionMatrix(hud.stage.getCamera().projection);
//        hud.stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        game.batch.dispose();
    }

    private void update(float delta) {

        handleInput(delta);
        gameCam.update();
        renderer.setView(gameCam);
    }

    private void handleInput(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            gameCam.position.x += 100 * delta;
            System.out.println(gameCam.position.x);
        }
    }
}