package com.oscardiegojesus.professort.Sprites.Level1;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Timer;
import com.oscardiegojesus.professort.ProfessorT;
import com.oscardiegojesus.professort.Scenes.Hud;
import com.oscardiegojesus.professort.Screens.PlayScreen;
import com.oscardiegojesus.professort.Screens.PlayScreen2;
import com.oscardiegojesus.professort.Tools.WorldContactListener;

public class Player extends Sprite {


    public enum State {FALLING, JUMPING, STANDING, RUNNING, DEAD, LEVEL1, FINALDEAD}

    public Array<PaperPlane> paperplanes;
    public State currentState;
    public State previousState;
    public World world;
    public Body b2body;
    private TextureRegion playerStand;
    private Animation playerRun;
    private TextureRegion playerJump;
    private TextureRegion playerDead;
    private float stateTimer;
    private boolean runningRight;
    private PlayScreen screen;
    public static Integer score = 0;
    FixtureDef fdef = new FixtureDef();

    public Player(PlayScreen screen) {

        super(screen.getAtlas().findRegion("Sprites"));
        this.world = screen.getWorld();
        this.screen = screen;
        currentState = State.STANDING;
        previousState = State.STANDING;
        stateTimer = 0;
        runningRight = true;
        paperplanes = new Array<PaperPlane>();
        int arrsize = paperplanes.size;

        Array<TextureRegion> frames = new Array<TextureRegion>();

        for (int i = 1; i < 4; i++)
            frames.add(new TextureRegion(getTexture(), i * 27, 0, 26, 56));
        playerRun = new Animation(0.1f, frames);
        frames.clear();

        playerJump = new TextureRegion(screen.getAtlas().findRegion("jumping"), 0, 0, 33, 53);

        definePlayer();
        playerStand = new TextureRegion(getTexture(), 3, 0, 26, 56);

        playerDead = new TextureRegion(getTexture(), 411, 0, 26, 27);//muerto por jugarle al vergas

        setBounds(256, 64, 16 / ProfessorT.PPM, 32 / ProfessorT.PPM);
        setRegion(playerStand);
    }


    private void definePlayer() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(32 / ProfessorT.PPM, 32 / ProfessorT.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        //FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(6 / ProfessorT.PPM);

        //PolygonShape shape = new PolygonShape();
        //shape.setAsBox(6/ProfessorT.PPM, 6 /ProfessorT.PPM);

        fdef.filter.categoryBits = ProfessorT.PLAYER_BIT;
        fdef.filter.maskBits =  (ProfessorT.GROUND_BIT | ProfessorT.GREENPENCIL_BIT
                        | ProfessorT.OBJECT_BIT | ProfessorT.ENEMY_BIT | ProfessorT.ENEMY_SIDE_BIT
                        | ProfessorT.BOOK_BIT |ProfessorT.TEC_BIT| ProfessorT.PENCILSIDE_BIT|
                ProfessorT.ENEMY2_SIDE_BIT| ProfessorT.FALSEGROUND_BIT |ProfessorT.ENEMY2_BIT);

        fdef.shape = shape;
        b2body.createFixture(fdef);

        EdgeShape head = new EdgeShape();
        head.set(new Vector2(-7 / ProfessorT.PPM, 10 / ProfessorT.PPM), new Vector2(7 / ProfessorT.PPM, 10 / ProfessorT.PPM));
        fdef.shape = head;
        fdef.isSensor = true;
        b2body.createFixture(fdef).setUserData("head");


        EdgeShape leftside = new EdgeShape();
        leftside.set(new Vector2(-7 / ProfessorT.PPM, 7 / ProfessorT.PPM),
                new Vector2(-7 / ProfessorT.PPM, -7 / ProfessorT.PPM));
        fdef.shape = leftside;
        fdef.isSensor = true;
        b2body.createFixture(fdef).setUserData("leftside");

        EdgeShape rightside = new EdgeShape();
        rightside.set(new Vector2(7 / ProfessorT.PPM, 7 / ProfessorT.PPM),
                new Vector2(7 / ProfessorT.PPM, -7 / ProfessorT.PPM));
        fdef.shape = rightside;
        fdef.isSensor = true;
        b2body.createFixture(fdef).setUserData("rightside");
    }

    public void update(float delta) {
        setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
        setRegion(getFrame(delta));

        for (PaperPlane paper : paperplanes) {
            paper.update(delta);
            if (paper.isDestroyed())
                paperplanes.removeValue(paper, true);
        }
    }

    public TextureRegion getFrame(float delta) {
        currentState = getState();
        TextureRegion region;
        switch (currentState) {
            case JUMPING:
                region = playerJump;
                break;
            case DEAD:
                region = playerDead;
                break;
            case FINALDEAD:
                region = playerDead;
                Hud.addLives(3);
                break;
            case RUNNING:
                region = playerRun.getKeyFrame(stateTimer, true); //loop en las imagenes
                break;
            case FALLING:
            case LEVEL1:
            default:
                region = playerStand;
                break;
        }
            if ((b2body.getLinearVelocity().x < 0 || !runningRight) && !region.isFlipX()) {
                region.flip(true, false);
                runningRight = false;
            } else if ((b2body.getLinearVelocity().x > 0 || runningRight) && region.isFlipX()) {
                region.flip(true, false);
                runningRight = true;
            }
            stateTimer = currentState == previousState ? stateTimer + delta : 0;
            previousState = currentState;

            return region;
        }

    public State getState() {
        if (b2body.getLinearVelocity().y > 0 || (b2body.getLinearVelocity().y < 0 && previousState == State.JUMPING))
            return State.JUMPING;
        else if(Hud.health<=0) {
            paperplanes.clear();
            ProfessorT.manager.get("Music/sounds/playerdie.wav", Sound.class).play();
            Hud.addLives(-1);
            Hud.removeHealth(100);
            return State.DEAD;
        }
        else if(Hud.lives==0) {
            ProfessorT.manager.get("Music/sounds/gameover.wav", Sound.class).play();
            return State.FINALDEAD;
        }
        else if(WorldContactListener.falseground) {
            paperplanes.clear();
            ProfessorT.manager.get("Music/sounds/playerdie.wav", Sound.class).play();
            Hud.addLives(-1);
            if(Hud.health!=100)
                Hud.removeHealth(100-Hud.health);
            WorldContactListener.falseground = false;
            return State.DEAD;
        }
        else if(Hud.worldTimer==0) {
            paperplanes.clear();
            ProfessorT.manager.get("Music/sounds/playerdie.wav", Sound.class).play();
            Hud.addLives(-1);
            if(Hud.health!=100)
                Hud.removeHealth(100-Hud.health);
            return State.DEAD;
        }
        else if(Hud.worldTimer==100) { //hurry up sound
            ProfessorT.manager.get("Music/sounds/hurry.wav", Sound.class).play();
            return State.STANDING;
        }
        else if(WorldContactListener.level1_2) {
            paperplanes.clear();
            return State.LEVEL1;
        }
        else if (b2body.getLinearVelocity().y < 0)
            return State.FALLING;
        else if (b2body.getLinearVelocity().x != 0)
            return State.RUNNING;
        else
            return State.STANDING;
    }

    public void fire(){
        int arrsize = paperplanes.size;
       if(arrsize==0) {
           paperplanes.add(new PaperPlane(screen, b2body.getPosition().x, b2body.getPosition().y, runningRight ? true : false));
           Hud.addPlanes(-1);
       }
    }

    public void jump(){
        if (currentState != State.JUMPING) {
            b2body.applyLinearImpulse(new Vector2(0, 3.7f), b2body.getWorldCenter(), true);
            currentState = State.JUMPING;
        }
    }

    public void draw(Batch batch){
        super.draw(batch);
        for(PaperPlane plane : paperplanes)
            plane.draw(batch);
    }
}
