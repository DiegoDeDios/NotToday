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
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.oscardiegojesus.professort.ProfessorT;
import com.oscardiegojesus.professort.Scenes.Hud;

public class GameComplete implements Screen {
    private ScreenViewport viewport;
    private Stage stage;
    private Game game;
    private SpriteBatch batch;
    private Texture img;

    public GameComplete(Game game){

        this.game = game;
        batch = new SpriteBatch();
        img = new Texture("gamecomplete.png");
        viewport = new ScreenViewport(new OrthographicCamera());
        stage = new Stage(viewport, ((ProfessorT) game).batch);

        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.BLUE);

        Table table = new Table();
        table.center();
        table.setFillParent(true);

        Table table1 = new Table();
        table1.top(); //alinear a la parte de arriba
        table1.setFillParent(true); // La tabla es del tamaño del stage

        Label gameOverLabel = new Label("GAME COMPLETED!", font);
        Label quitlabel = new Label("Presione Q para cerrar", font);
        Label oscarlabel = new Label("Oscar Alfonso Flores", font);
        Label diegolabel = new Label("Diego Martínez", font);
        Label jesuslabel = new Label("Jesús Rellstab", font);
        Label blanklabel = new Label(" ", font);
        Label blanklabel2 = new Label(" ", font);
        Label blanklabel3 = new Label(" ", font);
        Label professorlabel = new Label("Thanks for Playing Professor-T", font);
        Label scorelabel = new Label("Final Score:" +Hud.score, font);


        table.add(gameOverLabel).expandX();
        table.row();
        table.add(scorelabel).expandX().padTop(10f);
        table.row();
        table.add(quitlabel).expandX().padTop(10f);
        table.row();
        table.add(blanklabel).expandX().padTop(10f);
        table.row();
        table.add(blanklabel2).expandX().padTop(10f);
        table.row();
        table.add(blanklabel3).expandX().padTop(10f);
        table.row();

        table1.add(oscarlabel).expandX();
        table1.add(diegolabel).expandX();
        table1.add(jesuslabel).expandX();
        table1.row();
        table1.add(blanklabel2).expandX();
        table1.add(professorlabel).expandX();

        stage.addActor(table);
        stage.addActor(table1);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        if(Gdx.input.isKeyPressed(Input.Keys.Q)) {
            Gdx.app.exit();
            dispose();
        }
        Gdx.gl.glClearColor(255, 255, 255, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 60, 0);
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