package domain.player;

import domain.Deck;
import domain.betting.bettingstate.BettingState;
import domain.betting.bettingstate.IdiotBettingState;
import domain.betting.bettingstate.InitBettingState;
import vo.BettingCase;
import vo.Chips;

public abstract class AbstractPlayer implements Winner, Loser, Player {
    private boolean firstBetter;
    private String name;
    private Deck deck;
    private Chips chips;

    private BettingState bettingState;

    public AbstractPlayer(String name, Deck deck, Chips chips, boolean firstBetter) {
        this.name = name;
        this.deck = deck;
        this.chips = chips;
        this.firstBetter = firstBetter;
        this.bettingState = new InitBettingState(payChips(1), BettingCase.RAISE_CASE, this);
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

    @Override
    public BettingState betting(Chips chips, BettingCase bettingCase) {
        return this.bettingState = this.bettingState.betting(chips, bettingCase);
    }

    @Override
    public boolean isFirst() {
        return this.firstBetter;
    }

    @Override
    public void changeLastBetter() {

        this.firstBetter = false;
    }

    @Override
    public void changeFirstBetter() {
        this.firstBetter = true;
    }
}
