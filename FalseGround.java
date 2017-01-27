package com.oscardiegojesus.professort.Sprites;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;
import com.oscardiegojesus.professort.ProfessorT;
import com.oscardiegojesus.professort.Screens.PlayScreen;

public class FalseGround extends InteractiveTiledObject {

    public FalseGround(PlayScreen screen, Rectangle bounds) {
        super(screen, bounds);
        fixture.setUserData(this);
        setCategoryFilter(ProfessorT.FALSEGROUND_BIT);
    }

    @Override
    public void onHeadHit() {
        ProfessorT.manager.get("Music/sounds/playerdie.wav", Sound.class).play();
    }
}
