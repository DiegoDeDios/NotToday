package com.oscardiegojesus.professort.Sprites.Level1;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.oscardiegojesus.professort.Screens.PlayScreen;


public abstract class Enemigos extends Sprite {
    protected World world;
    protected PlayScreen screen;
    public Body b2body;
    public Vector2 velocity;

    public Enemigos(PlayScreen screen, float x, float y){
        this.world=screen.getWorld();
        this.screen=screen;
        setPosition(x, y);
        defineBorreguito();
        velocity = new Vector2(-1, -2);
        b2body.setActive(false);
    }

    protected abstract void defineBorreguito();

    public abstract void update(float delta);

    public abstract void hitOnHead();

    public void reverseVelocity(boolean x, boolean y){
        if(x)
            velocity.x = -velocity.x;
        if(y)
            velocity.y = -velocity.y;
    }
}
