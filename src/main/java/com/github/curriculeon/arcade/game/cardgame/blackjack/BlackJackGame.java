package com.github.curriculeon.arcade.game.cardgame.blackjack;

import com.github.curriculeon.arcade.game.cardgame.highlow.HighLowPlayer;
import com.github.curriculeon.arcade.game.cardgame.utils.AbstractCardGame;
import com.github.curriculeon.arcade.profile.ProfileInterface;
import com.github.curriculeon.arcade.profile.ProfileManager;

public class BlackJackGame extends AbstractCardGame<BlackJackPlayer> {
    @Override
    public void run() {
        for(BlackJackPlayer player : getPlayers()) {
            getConsole().println(player.toString());
        }
    }

    @Override
    public void createPlayers() {
        int numberOfPlayers = 2;
        for (int i = 0; i < numberOfPlayers; i++) {
            final String infoMessage = "Player number [ %s ], enter your profile id.";
            final Long playerId = getConsole().getLongInput(infoMessage, i);
            final ProfileInterface profile = ProfileManager.INSTANCE.getProfileById(playerId);
            final BlackJackPlayer blackJackPlayer = new BlackJackPlayer(profile);
            addPlayer(blackJackPlayer);
        }
    }
}
