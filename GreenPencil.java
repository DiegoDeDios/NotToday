package com.oscardiegojesus.professort.Sprites;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;
import com.oscardiegojesus.professort.ProfessorT;
import com.oscardiegojesus.professort.Scenes.Hud;
import com.oscardiegojesus.professort.Screens.PlayScreen;
import com.oscardiegojesus.professort.Screens.PlayScreen2;
import com.oscardiegojesus.professort.Screens.PlayScreen3;
import com.oscardiegojesus.professort.Screens.PlayScreen4;


public class GreenPencil extends InteractiveTiledObject {

    public GreenPencil(PlayScreen screen, Rectangle bounds) {
        super(screen, bounds);
        fixture.setUserData(this);
        setCategoryFilter(ProfessorT.GREENPENCIL_BIT);
    }

    public GreenPencil(PlayScreen2 screen2, Rectangle bounds) {
        super(screen2, bounds);
        fixture.setUserData(this);
        setCategoryFilter(ProfessorT.GREENPENCIL_BIT);
    }

    public GreenPencil(PlayScreen3 screen3, Rectangle bounds) {
        super(screen3, bounds);
        fixture.setUserData(this);
        setCategoryFilter(ProfessorT.GREENPENCIL_BIT);
    }

    public GreenPencil(PlayScreen4 screen4, Rectangle bounds) {
        super(screen4, bounds);
        fixture.setUserData(this);
        setCategoryFilter(ProfessorT.GREENPENCIL_BIT);
    }

    @Override
    public void onHeadHit() {
        ProfessorT.manager.get("Music/sounds/life.mp3", Sound.class).play();
        setCategoryFilter(ProfessorT.NOTHING_BIT);
        getPencil().setTile(null);
        Hud.addLives(1);
    }
}

