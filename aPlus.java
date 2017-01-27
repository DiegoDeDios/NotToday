package com.oscardiegojesus.professort.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;
import com.oscardiegojesus.professort.ProfessorT;
import com.oscardiegojesus.professort.Screens.PlayScreen;
import com.oscardiegojesus.professort.Screens.PlayScreen2;
import com.oscardiegojesus.professort.Screens.PlayScreen3;


public class aPlus extends InteractiveTiledObject {


    public aPlus(PlayScreen screen, Rectangle bounds) {
        super(screen, bounds);
        fixture.setUserData(this);
        setCategoryFilter(ProfessorT.TEC_BIT);
    }

    public aPlus(PlayScreen2 screen2, Rectangle bounds) {
        super(screen2, bounds);
        fixture.setUserData(this);
        setCategoryFilter(ProfessorT.TEC2_BIT);
    }

    public aPlus(PlayScreen3 screen3, Rectangle bounds) {
        super(screen3, bounds);
        fixture.setUserData(this);
        setCategoryFilter(ProfessorT.TEC3_BIT);
    }


    @Override
    public void onHeadHit() {
        ProfessorT.manager.get("Music/sounds/levelclear.mp3", Sound.class).play();
        setCategoryFilter(ProfessorT.NOTHING_BIT);
        Gdx.app.log("a+", "colision");
    }
}
