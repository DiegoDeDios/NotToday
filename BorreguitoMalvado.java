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

public class BorreguitoMalvado extends Enemigos {
    private float stateTime;
    private Animation walkAnimation;
    private Array<TextureRegion> frames;
    private boolean setToDestroy;
    private boolean destroyed;
    float angle;

    public BorreguitoMalvado(PlayScreen screen, float x, float y) {
        super(screen, x, y);
        frames = new Array<TextureRegion>();
        frames.add(new TextureRegion(screen.getAtlas1().findRegion("SpritesAll"), 1 ,77, 21, 20));
        walkAnimation = new Animation(0.4f, frames);
        stateTime = 0;
        setBounds(getX(), getY(), 16 / ProfessorT.PPM, 16 / ProfessorT.PPM);
        setToDestroy = false;
        destroyed = false;
        angle = 0;
    }
    @Override
    protected void defineBorreguito() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(getX(), getY());
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        //PolygonShape shape = new PolygonShape();
        CircleShape shape = new CircleShape();

        //shape.setAsBox(4/ProfessorT.PPM, 4/ProfessorT.PPM);
        shape.setRadius(6 / ProfessorT.PPM);

        fdef.filter.categoryBits = ProfessorT.ENEMY_BIT;
        fdef.filter.maskBits = ProfessorT.GROUND_BIT |
                ProfessorT.ENEMY_BIT |
                ProfessorT.OBJECT_BIT |
                ProfessorT.PLAYER_BIT|
                ProfessorT.PLANES_BIT;


        fdef.shape = shape;
        b2body.createFixture(fdef).setUserData(this);

        //Create the Head here:
        PolygonShape head = new PolygonShape();
        Vector2[] vertice = new Vector2[4];
        vertice[0] = new Vector2(-5, 8).scl(1 / ProfessorT.PPM);
        vertice[1] = new Vector2(5, 8).scl(1 / ProfessorT.PPM);
        vertice[2] = new Vector2(-3, 3).scl(1 / ProfessorT.PPM);
        vertice[3] = new Vector2(3, 3).scl(1 / ProfessorT.PPM);
        head.set(vertice);

        fdef.shape = head;
        fdef.restitution = 1.5f;
        fdef.filter.categoryBits = ProfessorT.ENEMY_SIDE_BIT;
        b2body.createFixture(fdef).setUserData(this);
    }


    public void update(float delta) {
        stateTime += delta;
        if (setToDestroy && !destroyed) {
            world.destroyBody(b2body);
            destroyed = true;
            setRegion(new TextureRegion(screen.getAtlas1().findRegion("SpritesAll"), 21, 77, 21, 20));
            stateTime = 0;
        } else if (!destroyed) {
            b2body.setLinearVelocity(velocity);
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            setRegion(walkAnimation.getKeyFrame(stateTime, true));
            FixtureDef fdef = new FixtureDef();
            fdef.filter.categoryBits = ProfessorT.DEATH_ENEMY_BIT;
        }
    }
    public void draw(Batch batch) {
        if (!destroyed || stateTime < 1)
            super.draw(batch);

    }
    @Override
    public void hitOnHead() {
        setToDestroy = true;
        Hud.addScore(100);
        ProfessorT.manager.get("Music/sounds/stomp.wav", Sound.class).play();
    }
}