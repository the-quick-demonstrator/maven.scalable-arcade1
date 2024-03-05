package com.github.curriculeon.arcade.game.cardgame.highlow;

import com.github.curriculeon.arcade.game.cardgame.utils.AbstractCardGame;
import com.github.curriculeon.arcade.game.cardgame.utils.Deck;
import com.github.curriculeon.arcade.game.cardgame.utils.card.Card;
import com.github.curriculeon.arcade.game.cardgame.utils.card.CardInterface;
import com.github.curriculeon.arcade.profile.Profile;
import com.github.curriculeon.arcade.profile.ProfileInterface;
import com.github.curriculeon.arcade.profile.ProfileManager;
import com.github.curriculeon.utils.Pair;

/**
 * Created by leon on 6/24/2020.
 */
public class HighLowGame extends AbstractCardGame<HighLowPlayer> {
    private Pair<HighLowPlayer, CardInterface> highestScoringPlayerAndCard;

    @Override
    public void createPlayers() {
        int numberOfPlayers = 2;
        for (int i = 0; i < numberOfPlayers; i++) {
            String infoMessage = "Player number [ %s ], enter your profile id.";
            Long playerId = getConsole().getLongInput(infoMessage, i);
            ProfileInterface profile = ProfileManager.INSTANCE.getProfileById(playerId);
            HighLowPlayer highLowPlayer = new HighLowPlayer(profile);
            addPlayer(highLowPlayer);
        }
    }

    @Override
    public void run() {
        HighLowPlayer dealer = new HighLowPlayer(new Profile("DEALER", Double.MAX_VALUE, null));
        getDiscardPile().add(dealer, getDeck().pop());
        Deck deck = new Deck();
        deck.shuffle();
        getPlayers().forEach(player -> player.addCard(deck.pop()));
    }

    public CardInterface getCurrentFaceUpValue() {
        return getDiscardPile().getOwnerAndCardAtIndex(0).getValue();
    }

    public void evaluateCardAndPlayer(Pair<HighLowPlayer, CardInterface> ownerAndCard) {
        if (highestScoringPlayerAndCard != null) {
            Integer highestScoringPlayerCardValue = highestScoringPlayerAndCard
                    .getValue()
                    .getValue();

            Integer currentPlayerCardValue = getCurrentFaceUpValue().getValue();

            if (highestScoringPlayerCardValue < currentPlayerCardValue) {
                highestScoringPlayerAndCard = new Pair<>(ownerAndCard.getKey(), getCurrentFaceUpValue());
            }
        } else {
            this.highestScoringPlayerAndCard = getDiscardPile().getOwnerAndCardAtIndex(0);
        }
    }

    public Pair<HighLowPlayer, CardInterface>  getHighestScoringPlayerAndCard() {
        return highestScoringPlayerAndCard;
    }
}
