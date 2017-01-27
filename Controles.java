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
import com.oscardiegojesus.professort.Scenes.Hud;

/**
 * Created by oscaralfonso on 10/05/16.
 */
public class Controles implements Screen {
    private ScreenViewport viewport;
    private Stage stage;
    private Game game;
    private SpriteBatch batch;
    private Texture img;

    public Controles(Game game){
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

        Label label1 = new Label("W para saltar", font);
        Label label2 = new Label("A para moverse a la izquierda", font);
        Label label3 = new Label("D para moverse a la derecha", font);
        Label label4 = new Label("J para disparar (si se tienen aviones)", font);
        Label label5 = new Label("K para correr", font);

        Label controleslabel = new Label("2 para regresar", font);

        table.add(label1).expandX().padTop(10f);
        table.row();
        table.add(label2).expandX().padTop(10f);
        table.row();
        table.add(label3).expandX().padTop(10f);
        table.row();
        table.add(label4).expandX().padTop(10f);
        table.row();
        table.add(label5).expandX().padTop(10f);
        table.row();
        table1.add(controleslabel).expandX().padTop(20f);


        stage.addActor(table);
        stage.addActor(table1);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        if(Gdx.input.isKeyPressed(Input.Keys.NUM_2)){
            game.setScreen(new FirstScreen((ProfessorT) game));
            dispose();
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
