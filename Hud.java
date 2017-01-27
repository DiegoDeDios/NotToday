package com.oscardiegojesus.professort.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.oscardiegojesus.professort.ProfessorT;
import com.oscardiegojesus.professort.Screens.PlayScreen4;
import com.oscardiegojesus.professort.Sprites.Level1.Player;
import com.oscardiegojesus.professort.Sprites.Level4.FinalBoss;

public class Hud implements Disposable {
    public Stage stage;
    private Viewport viewport;
    public static Integer worldTimer;
    private boolean timeUp;
    public static Integer lives = 3;
    private float timeCount;
    private static Integer planes;
    public static Integer health = 100;
    public static Integer score = 0;


    Label countdownlabel;
    static Label scorelabel;
    Label timelabel;
    Label worldlabel;
    Label playerlabel;
    static Label liveslabel;
    Label healthlabel;
    Label planeslabel;
    static Label healthnumberlabel;
    static Label planesnumberlabel;
    Label bosslabel;
    Label bosslifelabel;


    public Hud(SpriteBatch sp) {
        worldTimer = 300;
        timeCount = 0;
        planes = 0;
        viewport = new FitViewport(ProfessorT.V_WIDTH, ProfessorT.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sp);

        Table table = new Table();
        table.top(); //alinear a la parte de arriba
        table.setFillParent(true); // La tabla es del tamaño del stage

        countdownlabel = new Label(String.format("%03d", worldTimer), new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        scorelabel = new Label(String.format("%06d", score), new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        timelabel = new Label("TIME", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        worldlabel = new Label("SCORE", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        playerlabel = new Label("LIVES:", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        liveslabel = new Label(String.format("%02d", lives), new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        healthlabel = new Label("HEALTH:", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        healthnumberlabel = new Label(String.format("%03d", health), new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        planesnumberlabel = new Label(String.format("%03d", planes), new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        planeslabel = new Label("PLANES:", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        bosslabel = new Label("BOSS LIFE", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        bosslifelabel = new Label(String.format("%03d", FinalBoss.bosslife), new Label.LabelStyle(new BitmapFont(), Color.BLACK));


        table.add(playerlabel).expandX().padTop(3);
        table.add(healthlabel).expandX().padTop(3);
        table.add(worldlabel).expandX().padTop(3);
        table.add(timelabel).expandX().padTop(3);
        table.add(planeslabel).expandX().padTop(3);
        table.row();
        table.add(liveslabel).expandX();
        table.add(healthnumberlabel).expandX();
        table.add(scorelabel).expandX();
        table.add(countdownlabel).expandX();
        table.add(planesnumberlabel).expandX();
        table.row();

        stage.addActor(table);
    }

    public static void addScore(int valor) {
        score += valor;
        scorelabel.setText(String.format("%06d", score));
    }

    public static void removeHealth(int valor) {
        health += valor;
        healthnumberlabel.setText(String.format("%03d", health));
    }
    public static void addLives(int valor) {
        lives += valor;
        liveslabel.setText(String.format("%02d", lives));
    }

    public static void addPlanes(int valor) {
        planes += valor;
        planesnumberlabel.setText(String.format("%02d", planes));
    }

    public static Integer getPlanes() {
        return planes;
    }

    public void dispose() {
        stage.dispose();

    }

    public void update(float delta) {
        timeCount += delta;
        if (timeCount >= 1) {
            if (worldTimer > 0) {
                worldTimer--;
            } else {
                timeUp = true;
            }
            countdownlabel.setText(String.format("%03d", worldTimer));
            timeCount = 0;
        }
    }
}

