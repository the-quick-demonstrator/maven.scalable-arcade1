package com.github.curriculeon.arcade.game.cardgame.highlow;

import com.github.curriculeon.arcade.game.cardgame.utils.card.CardInterface;
import com.github.curriculeon.arcade.game.utils.GameDecisionInterface;
import com.github.curriculeon.utils.InputOutputConsoleInterface;

import java.util.function.BiConsumer;

/**
 * Created by leon on 6/24/2020.
 */
public enum HighLowGameDecision implements GameDecisionInterface<HighLowGame, HighLowPlayer> {
    VIEW_HAND((game, player) -> {
        game.getConsole().println(player.getHand().toString());
    }),

    VIEW_DISCARD_PILE((game, player) -> {
        game.getConsole().println(game
                .getDiscardPile()
                .getOwnerAndCardAtIndex(0)
                .getValue()
                .toString());
    }),

    DECIDE_HIGH((game, player) -> {
        player.setDecision(HighLowPlayer.DecisionState.HIGH);
        String infoMessage = "[ %s ] has claimed their hand-value is `HIGHER` than the current face-up value of [ %s ]";
        CardInterface currentFaceUpCard = game.getCurrentFaceUpValue();
        game
                .getConsole()
                .println(infoMessage, player.getName(), currentFaceUpCard);
        game
                .getDiscardPile()
                .add(player, player.getCard());
    }),


    DECIDE_LOW((game, player) -> {
        player.setDecision(HighLowPlayer.DecisionState.LOW);
        String infoMessage = "[ %s ] has claimed their hand-value is `LOWER` than the current face-up value of [ %s ]";
        CardInterface currentFaceUpCard = game.getCurrentFaceUpValue();
        game
                .getConsole()
                .println(infoMessage, player.getName(), currentFaceUpCard);
        game
                .getDiscardPile()
                .add(player, player.getCard());
    }),

    DECIDE_BLUFF((game, player) -> {
        player.setDecision(HighLowPlayer.DecisionState.BLUFF);
        InputOutputConsoleInterface console = game.getConsole();
        String claimMessage = "[ %s ] believes the previous player, [ %s ], did not have a hand-state of [ %s ]";
        String previousCardInfoMessage = "Previous-card was [ %s ]";
        String previousPreviousCardInfoMessage = "Previous-previous-card was [ %s ]";
        String claimAffirmationMessage = "[ %s ]'s claim that [ %s ] did not have a hand-state of [ %s ] was [ %s ]";

        HighLowPlayer previousPlayer = game
                .getDiscardPile()
                .getOwnerAndCardAtIndex(0)
                .getKey();

        CardInterface previousCard = game
                .getDiscardPile()
                .getOwnerAndCardAtIndex(0)
                .getValue();

        CardInterface previousPreviousCard = game
                .getDiscardPile()
                .getOwnerAndCardAtIndex(1)
                .getValue();

        Boolean previousPlayerDecidedHigh = previousPlayer.getDecision().equals(HighLowPlayer.DecisionState.HIGH);
        Boolean previousPlayerDecidedLow = previousPlayer.getDecision().equals(HighLowPlayer.DecisionState.LOW);
        Boolean previousPlayerHasHigh = previousPreviousCard.getValue() < previousCard.getValue();
        Boolean previousPlayerHasLow = previousPreviousCard.getValue() > previousCard.getValue();

        Boolean previousPlayerClaimIsTrue = (
                previousPlayerDecidedHigh && previousPlayerHasHigh) || (
                previousPlayerDecidedLow && previousPlayerHasLow);

        console.println(claimMessage,
                previousPlayer.getName(),
                player.getName(),
                previousPlayer.getDecision().name());

        console.println(previousCardInfoMessage, previousCard);
        console.println(previousPreviousCardInfoMessage, previousPreviousCard);
        console.print(claimAffirmationMessage, player.getName(), previousPlayer.getName(), previousPlayer.getDecision(), previousPlayerClaimIsTrue);

        if (previousPlayerClaimIsTrue) {
            previousPlayer.increasePoints(1);
            player.decreasePoints(1);
        }
    });

    private final BiConsumer<HighLowGame, HighLowPlayer> operation;

    HighLowGameDecision(BiConsumer<HighLowGame, HighLowPlayer> operation) {
        this.operation = operation;
    }

    @Override
    public BiConsumer<HighLowGame, HighLowPlayer> getProcedure() {
        return operation;
    }
}
