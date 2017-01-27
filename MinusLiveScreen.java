package com.oscardiegojesus.professort.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.oscardiegojesus.professort.ProfessorT;
import com.oscardiegojesus.professort.Scenes.Hud;

public class MinusLiveScreen implements Screen {
    private Viewport viewport;
    private Stage stage;

    private Game game;

    public MinusLiveScreen(Game game){
        this.game = game;
        viewport = new FitViewport(ProfessorT.V_WIDTH, ProfessorT.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, ((ProfessorT) game).batch);

        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);

        Table table = new Table();
        table.center();
        table.setFillParent(true);

        Label playAgainLabel = new Label("Click para volver a empezar", font);
        Label liveslabel = new Label("Lives: "+Hud.lives, font);

        table.row();
        table.add(playAgainLabel).expandX().padTop(10f);
        table.row();
        table.add(liveslabel).expandX().padTop(10f);

        stage.addActor(table);
    }

    public void show() {

    }

    public void render(float delta) {
        if(Gdx.input.justTouched()) {
            game.setScreen(new PlayScreen2((ProfessorT) game));
            dispose();
        }
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }

    public void resize(int width, int height) {

    }
    public void pause() {

    }

    public void resume() {

    }
    public void hide() {

    }

    public void dispose() {
        stage.dispose();
    }
}
