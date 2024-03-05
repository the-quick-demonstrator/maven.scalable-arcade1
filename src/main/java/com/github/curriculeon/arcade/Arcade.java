package com.github.curriculeon.arcade;

import com.github.curriculeon.arcade.profile.Profile;
import com.github.curriculeon.arcade.profile.ProfileManager;
import com.github.curriculeon.arcade.profile.ProfileManagerInterface;
import com.github.curriculeon.arcade.utils.AbstractDecisionMenu;

/**
 * Created by leon on 6/25/2020.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public final class Arcade extends AbstractDecisionMenu<ArcadeDecision> implements ArcadeInterface {
    private ProfileManagerInterface profileManager = ProfileManager.INSTANCE;

    public Arcade() {
        super(ArcadeDecision.values());
    }

    @Override
    public final ProfileManagerInterface getProfileManager() {
        return profileManager;
    }

    @Override
    public void setProfileManager(ProfileManagerInterface profileManager) {
        this.profileManager = profileManager;
    }

    @Override
    public void run() {
        getProfileManager().registerProfile(new Profile("test-profile+" + System.nanoTime(), Double.MAX_VALUE, 0L));
        getProfileManager().registerProfile(new Profile("test-profile+" + System.nanoTime(), Double.MAX_VALUE, 1L));
        while (true) {
            getInput().perform(this);
        }
    }
}