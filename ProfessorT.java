package com.oscardiegojesus.professort;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.oscardiegojesus.professort.Screens.FirstScreen;
import com.oscardiegojesus.professort.Screens.PlayScreen4;


public class ProfessorT extends Game {
	public SpriteBatch batch;
    public static AssetManager manager;
	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 208;
	public static final float PPM =  100;

	public static final short NOTHING_BIT = 0;
	public static final short GROUND_BIT = 1;
	public static final short PLAYER_BIT = 3;
	public static final short PENCIL_BIT = 4;
	public static final short PENCILSIDE_BIT = 6;
	public static final short PENCILSIDE2_BIT = 8;
	public static final short PENCILSIDE3_BIT = 12;
	public static final short GREENPENCIL_BIT = 17;
	public static final short PLANES2_BIT = 20;
	public static final short RAYOS_BIT = 24;
    public static final short OBJECT_BIT = 30;
    public static final short ENEMY_BIT = 64;
	public static final short ENEMY_SIDE_BIT = 128;
	public static final short BOSS_BIT = 168;
	public static final short SIDE_BIT = 320;
	public static final short DEATH_ENEMY_BIT = 512;
	public static final short BOOK_BIT = 1024;
    public static final short PLANES_BIT = 2048;
	public static final short PLANES3_BIT = 3500;
	public static final short BOSS_SIDE_BIT = 3980;
    public static final short ENEMY2_BIT = 4000;
    public static final short ENEMY4_BIT = 7900;
	public static final short TEC_BIT = 8400;
	public static final short TEC2_BIT = 10000;
    public static final short TEC3_BIT = 11500;
	public static final short ENEMY3_SIDE_BIT = 13500;
	public static final short FALSEGROUND_BIT = 16384;
	public static final short ENEMY2_SIDE_BIT = 18000;
    public static final short PLANES4_BIT = 20000;
    public static final short PENCILSIDE4_BIT = 21000;
    public static final short ENEMY4_SIDE_BIT = 22000;
    public static final short ENEMY3_BIT = 25000;

	@Override
	public void create () {
		batch = new SpriteBatch();
        manager = new AssetManager();

        manager.load("Music/background/fondo.mp3", Music.class);
		manager.load("Music/background/musica1.mp3", Music.class);
		manager.load("Music/background/musica2.mp3", Music.class);
		manager.load("Music/background/bossmusic.mp3", Music.class);
        manager.load("Music/sounds/Pencil.mp3", Sound.class);
        manager.load("Music/sounds/Paper Balls.mp3", Sound.class);
		manager.load("Music/sounds/levelclear.mp3", Sound.class);
        manager.load("Music/sounds/playerdie.wav", Sound.class);
		manager.load("Music/sounds/life.mp3", Sound.class);
        manager.load("Music/sounds/stomp.wav", Sound.class);
        manager.load("Music/sounds/powerup.wav", Sound.class);
		manager.load("Music/sounds/gameover.wav", Sound.class);
        manager.load("Music/sounds/hurry.wav", Sound.class);

        manager.finishLoading();

        setScreen(new FirstScreen(this));
	}

	@Override
	public void render () {
		super.render(); //game se dedica en renderizar todo del juego
	}

    public void dispose(){
        super.dispose();
        manager.dispose();
        batch.dispose();
    }
}