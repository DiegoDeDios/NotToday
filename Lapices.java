package com.oscardiegojesus.professort.Sprites.Level1;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Array;
import com.oscardiegojesus.professort.ProfessorT;
import com.oscardiegojesus.professort.Scenes.Hud;
import com.oscardiegojesus.professort.Screens.PlayScreen;
import com.oscardiegojesus.professort.Screens.PlayScreen2;

public class Lapices extends Objetos {
    private float stateTime;
    private Animation walkAnimation;
    private Array<TextureRegion> frames;
    private boolean setToDestroy;
    private boolean destroyed;
    float angle;

    public Lapices(PlayScreen screen, float x, float y) {
        super(screen, x, y);
        frames = new Array<TextureRegion>();
        frames.add(new TextureRegion(screen.getAtlasPencil().findRegion("Pencil"), 0, 0, 16, 16));
        walkAnimation = new Animation(0.4f, frames);
        stateTime = 0;
        setBounds(getX(), getY(), 16 / ProfessorT.PPM, 16 / ProfessorT.PPM);
        setToDestroy = false;
        destroyed = false;
        angle = 0;
    }

    @Override
    protected void defineObjetos() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(getX(), getY());
        bdef.type = BodyDef.BodyType.KinematicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(1 / ProfessorT.PPM);


        fdef.filter.categoryBits = ProfessorT.PENCILSIDE_BIT;
        fdef.filter.maskBits = ProfessorT.PLAYER_BIT;
        fdef.shape = shape;
        fdef.restitution=-0.9f;
        b2body.createFixture(fdef).setUserData(this);

    }

    public void update(float delta) {
        stateTime += delta;
        if (setToDestroy && !destroyed) {
            world.destroyBody(b2body);
            destroyed = true;
            stateTime = 0;
        } else if (!destroyed) {
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            setRegion(walkAnimation.getKeyFrame(stateTime, true));
            FixtureDef fdef = new FixtureDef();
            fdef.filter.categoryBits = ProfessorT.NOTHING_BIT;
        }
    }
    @Override
    public void hit() {
        setToDestroy = true;
        Hud.addScore(100);
        ProfessorT.manager.get("Music/sounds/Pencil.mp3", Sound.class).play();
    }

    public void draw(Batch batch) {
        if (!destroyed || stateTime < 0.1)
            super.draw(batch);
    }
}