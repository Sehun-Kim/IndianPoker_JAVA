package indianpoker.domain.player;

import support.domain.Deck;
import indianpoker.vo.Chips;

public class HumanPlayer extends AbstractPlayer {

    public HumanPlayer(String name, Deck deck, Chips chips, boolean firstBetter) {
        super(name, deck, chips, firstBetter);
    }

}
