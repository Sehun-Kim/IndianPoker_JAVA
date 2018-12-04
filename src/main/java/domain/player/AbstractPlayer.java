package domain.player;

import domain.Deck;
import domain.betting.bettingstate.BettingState;
import domain.betting.bettingstate.IdiotBettingState;
import vo.BettingCase;
import vo.Chips;

public abstract class AbstractPlayer implements Winner, Loser, Player {
    private boolean firstBetter = false;
    private String name;
    private Deck deck;
    private Chips chips;

    private BettingState bettingState;

    public AbstractPlayer(String name, Deck deck, Chips chips) {
        this.name = name;
        this.deck = deck;
        this.chips = chips;

    }

    public String getName() {
        return name;
    }

    public Deck getDeck() {
        return deck;
    }

    @Override
    public Chips showChips() {
        return this.chips;
    }

    @Override
    public Chips payChips(int i) {
        return this.chips.giveChips(i);
    }

    @Override
    public void gainChips(Chips chips) {
        this.chips.addChips(chips);
    }

    BettingState betting(Chips chips, BettingCase bettingCase) {
        return
    }
}
