package com.oscardiegojesus.professort.Sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.oscardiegojesus.professort.ProfessorT;
import com.oscardiegojesus.professort.Screens.PlayScreen;
import com.oscardiegojesus.professort.Screens.PlayScreen2;
import com.oscardiegojesus.professort.Screens.PlayScreen3;
import com.oscardiegojesus.professort.Screens.PlayScreen4;

public abstract class InteractiveTiledObject {
    protected World world;
    protected TiledMap map;
    protected Rectangle bounds;
    protected Body body;
    protected Fixture fixture;
    protected PlayScreen screen;
    protected PlayScreen2 screen2;
    protected PlayScreen3 screen3;
    protected PlayScreen4 screen4;


    public InteractiveTiledObject (PlayScreen screen, Rectangle bounds){
        this.screen = screen;
        this.world = screen.getWorld();
        this.map = screen.getMap();
        this.bounds = bounds;

        BodyDef bdef = new BodyDef();
        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();

        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set((bounds.getX() + bounds.getWidth() /2)  / ProfessorT.PPM ,
                (bounds.getY() + bounds.getHeight() /2)  / ProfessorT.PPM);

        body = world.createBody(bdef);
        shape.setAsBox((bounds.getWidth()/2) / ProfessorT.PPM ,(bounds.getHeight()/2) / ProfessorT.PPM);
        fdef.shape = shape;
        fixture = body.createFixture(fdef);
    }

    public InteractiveTiledObject (PlayScreen2 screen2, Rectangle bounds){
        this.screen2 = screen2;
        this.world = screen2.getWorld();
        this.map = screen2.getMap();
        this.bounds = bounds;

        BodyDef bdef = new BodyDef();
        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();

        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set((bounds.getX() + bounds.getWidth() /2)  / ProfessorT.PPM ,
                (bounds.getY() + bounds.getHeight() /2)  / ProfessorT.PPM);

        body = world.createBody(bdef);
        shape.setAsBox((bounds.getWidth()/2) / ProfessorT.PPM ,(bounds.getHeight()/2) / ProfessorT.PPM);
        fdef.shape = shape;
        fixture = body.createFixture(fdef);
    }

    public InteractiveTiledObject (PlayScreen3 screen3, Rectangle bounds){
        this.screen3 = screen3;
        this.world = screen3.getWorld();
        this.map = screen3.getMap();
        this.bounds = bounds;

        BodyDef bdef = new BodyDef();
        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();

        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set((bounds.getX() + bounds.getWidth() /2)  / ProfessorT.PPM ,
                (bounds.getY() + bounds.getHeight() /2)  / ProfessorT.PPM);

        body = world.createBody(bdef);
        shape.setAsBox((bounds.getWidth()/2) / ProfessorT.PPM ,(bounds.getHeight()/2) / ProfessorT.PPM);
        fdef.shape = shape;
        fixture = body.createFixture(fdef);
    }

    public InteractiveTiledObject (PlayScreen4 screen4, Rectangle bounds){
        this.screen4 = screen4;
        this.world = screen4.getWorld();
        this.map = screen4.getMap();
        this.bounds = bounds;

        BodyDef bdef = new BodyDef();
        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();

        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set((bounds.getX() + bounds.getWidth() /2)  / ProfessorT.PPM ,
                (bounds.getY() + bounds.getHeight() /2)  / ProfessorT.PPM);

        body = world.createBody(bdef);
        shape.setAsBox((bounds.getWidth()/2) / ProfessorT.PPM ,(bounds.getHeight()/2) / ProfessorT.PPM);
        fdef.shape = shape;
        fixture = body.createFixture(fdef);
    }

    public abstract void onHeadHit();

    public void setCategoryFilter(short filterBit){
        Filter filter = new Filter();
        filter.categoryBits = filterBit;
        fixture.setFilterData(filter);
    }

    public TiledMapTileLayer.Cell getPencil(){
        TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(1); //es para encontrar donde esta el lápiz
        return layer.getCell((int)(body.getPosition().x * ProfessorT.PPM / 16), //este es el eje x
                (int)(body.getPosition().y * ProfessorT.PPM / 16)); //este es el int y
    }

    public TiledMapTileLayer.Cell getBook(){
        TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(1); //es para encontrar donde esta el lápiz
        return layer.getCell((int)(body.getPosition().x * ProfessorT.PPM / 16), //este es el eje x
                (int)(body.getPosition().y * ProfessorT.PPM / 16)); //este es el int y
    }
}
