package com.github.curriculeon.arcade;

import com.github.curriculeon.arcade.profile.ProfileManagerInterface;

/**
 * Created by leon on 6/22/2020.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public interface ArcadeInterface extends Runnable {
    ProfileManagerInterface getProfileManager();
    void setProfileManager(ProfileManagerInterface profileManager);
    void run();
}
