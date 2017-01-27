package com.oscardiegojesus.professort.Sprites;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;
import com.oscardiegojesus.professort.ProfessorT;
import com.oscardiegojesus.professort.Scenes.Hud;
import com.oscardiegojesus.professort.Screens.PlayScreen;
import com.oscardiegojesus.professort.Screens.PlayScreen2;
import com.oscardiegojesus.professort.Screens.PlayScreen3;
import com.oscardiegojesus.professort.Screens.PlayScreen4;


public class Books extends InteractiveTiledObject {
    private static Integer planes;

    public Books(PlayScreen screen,Rectangle bounds) {
            super(screen, bounds);
            fixture.setUserData(this);
            setCategoryFilter(ProfessorT.BOOK_BIT);
            planes = 0;
        }

    public Books(PlayScreen2 screen2,Rectangle bounds) {
        super(screen2, bounds);
        fixture.setUserData(this);
        setCategoryFilter(ProfessorT.BOOK_BIT);
        planes = 0;
    }

    public Books(PlayScreen3 screen3,Rectangle bounds) {
        super(screen3, bounds);
        fixture.setUserData(this);
        setCategoryFilter(ProfessorT.BOOK_BIT);
        planes = 0;
    }

    public Books(PlayScreen4 screen4,Rectangle bounds) {
        super(screen4, bounds);
        fixture.setUserData(this);
        setCategoryFilter(ProfessorT.BOOK_BIT);
        planes = 0;
    }

    @Override
    public void onHeadHit() {
        ProfessorT.manager.get("Music/sounds/powerup.wav", Sound.class).play();
        setCategoryFilter(ProfessorT.NOTHING_BIT);
        getPencil().setTile(null);
        Hud.addPlanes(10);
    }

}
