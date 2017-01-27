package com.oscardiegojesus.professort.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.oscardiegojesus.professort.ProfessorT;

/**
 * Created by oscaralfonso on 10/05/16.
 */
public class FirstScreen implements Screen {
    private ScreenViewport viewport;
    private Stage stage;
    private Game game;
    private SpriteBatch batch;
    private Texture img;

    public FirstScreen(Game game){

        this.game = game;
        batch = new SpriteBatch();
        img = new Texture("FirstScreen.png");
        viewport = new ScreenViewport(new OrthographicCamera());
        stage = new Stage(viewport, ((ProfessorT) game).batch);

        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);

        Table table = new Table();
        table.center();
        table.setFillParent(true);

        Table table1 = new Table();
        table1.bottom();
        table1.setFillParent(true);

        Label gameOverLabel = new Label("¡Bienvenido a ProfessorT!", font);
        Label comenzarlabel = new Label("Click para comenzar", font);
        Label oscarlabel = new Label("Oscar Alfonso Flores", font);
        Label diegolabel = new Label("Diego Martínez", font);
        Label jesuslabel = new Label("Jesús Rellstab", font);

        Label controleslabel = new Label("1 para controles", font);
        Label quitlabel = new Label("Q para salir", font);

        table.add(gameOverLabel).expandX();
        table.row();
        table.row();
        table.add(comenzarlabel).expandX().padTop(10f);
        table.row();

        table.add(oscarlabel).expandX().padTop(10f);
        table.row();
        table.add(diegolabel).expandX();
        table.row();
        table.add(jesuslabel).expandX();
        table.row();

        table1.add(quitlabel).expandX().padTop(20f);
        table1.row();
        table1.add(controleslabel).expandX().padTop(20f);
        table1.row();


        stage.addActor(table);
        stage.addActor(table1);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        if(Gdx.input.justTouched()) {
            game.setScreen(new PlayScreen((ProfessorT) game));
            dispose();
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)){
            game.setScreen(new Controles((ProfessorT) game));
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.Q)){
           Gdx.app.exit();
        }

        Gdx.gl.glClearColor(255, 255, 255, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, -30, 0);
        batch.end();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

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
        stage.dispose();
    }
}
