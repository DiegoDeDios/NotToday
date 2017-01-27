package com.oscardiegojesus.professort.Sprites.Level1;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.oscardiegojesus.professort.ProfessorT;
import com.oscardiegojesus.professort.Screens.PlayScreen;
import com.oscardiegojesus.professort.Screens.PlayScreen2;

public class PaperPlane extends Sprite {

        PlayScreen screen;
        World world;
        Array<TextureRegion> frames;
        Animation fireAnimation;
        float stateTime;
        boolean destroyed;
        boolean setToDestroy;
        boolean fireRight;
        Body b2body;

        public PaperPlane(PlayScreen screen, float x, float y, boolean fireRight){
            this.fireRight = fireRight;
            this.screen = screen;
            this.world = screen.getWorld();
            frames = new Array<TextureRegion>();
            frames.add(new TextureRegion(screen.getAtlas1().findRegion("SpritesAll"), 0, 96, 20, 13));
            fireAnimation = new Animation(0.01f, frames);
            setRegion(fireAnimation.getKeyFrame(0));
            setBounds(x, y, 16 / ProfessorT.PPM, 16 / ProfessorT.PPM);
            defineFireBall();
        }

    public void defineFireBall(){
            BodyDef bdef = new BodyDef();
            bdef.position.set(fireRight ? getX() + 12 /ProfessorT.PPM : getX() - 12 /ProfessorT.PPM, getY());
            bdef.type = BodyDef.BodyType.DynamicBody;
            if(!world.isLocked())
                b2body = world.createBody(bdef);

            FixtureDef fdef = new FixtureDef();
            CircleShape shape = new CircleShape();
            shape.setRadius(7 / ProfessorT.PPM);
            fdef.filter.categoryBits = ProfessorT.PLANES_BIT;
            fdef.filter.maskBits = ProfessorT.GROUND_BIT |
                    ProfessorT.ENEMY_BIT |
                    ProfessorT.ENEMY_SIDE_BIT |
                    ProfessorT.OBJECT_BIT;

            fdef.shape = shape;
            fdef.restitution = 1f;
            fdef.friction = 0;
            b2body.createFixture(fdef).setUserData(this);
        //b2body.setLinearVelocity(new Vector2(fireRight ? 2 : -2, 2.5f));
        b2body.setLinearVelocity(new Vector2(fireRight ? 2f : -2f, 0));
        }

        public void update(float delta){
            stateTime += delta;
            setRegion(fireAnimation.getKeyFrame(stateTime, true));
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            if((stateTime > 3 || setToDestroy) && !destroyed) {
                world.destroyBody(b2body);
                destroyed = true;
            }
            if(b2body.getLinearVelocity().y > 2f)
               b2body.setLinearVelocity(b2body.getLinearVelocity().x, 2f);
            if((fireRight && b2body.getLinearVelocity().x < 0) || (!fireRight && b2body.getLinearVelocity().x > 0))
                setToDestroy();
        }

        public void setToDestroy(){
            setToDestroy = true;
        }

        public boolean isDestroyed(){
            return destroyed;
        }

    }

