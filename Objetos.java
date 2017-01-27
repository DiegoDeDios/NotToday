package com.oscardiegojesus.professort.Sprites.Level1;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.oscardiegojesus.professort.Screens.PlayScreen;


public abstract class Objetos extends Sprite {
    protected World world;
    protected PlayScreen screen;
    public Body b2body;
    public Vector2 velocity;

    public Objetos(PlayScreen screen, float x, float y){
        this.world=screen.getWorld();
        this.screen=screen;
        setPosition(x, y);
        defineObjetos();
        velocity = new Vector2(0,0);
        b2body.setActive(false);
    }

    protected abstract void defineObjetos();

    public abstract void update(float delta);

    public abstract void hit();
}
