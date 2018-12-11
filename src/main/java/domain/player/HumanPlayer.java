package domain.player;

import domain.Deck;
import domain.player.AbstractPlayer;
import vo.Chips;

public class HumanPlayer extends AbstractPlayer {

    public HumanPlayer(String name, Deck deck, Chips chips, boolean firstBetter) {
        super(name, deck, chips, firstBetter);
    }


}
