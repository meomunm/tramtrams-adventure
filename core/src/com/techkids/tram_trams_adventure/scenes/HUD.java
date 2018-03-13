package com.techkids.tram_trams_adventure.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.techkids.tram_trams_adventure.Program;

public class HUD {
    public Stage stage;
    private Viewport viewport;

    private Integer life;
    private Integer score;

    private Label lifeLabel;
    private Label scoreLabel;

    public HUD(SpriteBatch sb) {
        this.life = 3;
        this.score = 0;

        viewport = new FitViewport(Program.V_WIDTH, Program.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        lifeLabel = new Label("Life", new Label.LabelStyle(new BitmapFont(), new Color(Color.YELLOW)));
        scoreLabel = new Label(String.format("%s", this.score), new Label.LabelStyle(new BitmapFont(), new Color(Color.WHITE)));

        sb.begin();
        this.renderer(sb, lifeLabel, 30, Program.V_HEIGHT - 50);
        this.renderer(sb, scoreLabel, lifeLabel.getX() + 150, lifeLabel.getY());
        sb.end();
    }

    private void renderer(SpriteBatch sb, Label label, float x, float y) {
        label.setX(x);
        label.setY(y);
        label.setFontScale(1.5f);
        label.draw(sb, 0);
        stage.addActor(label);
    }
}

