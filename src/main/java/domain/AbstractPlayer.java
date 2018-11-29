package domain;

import vo.Chips;

public abstract class AbstractPlayer implements Player, Winner {
    private String name;
    private Deck deck;
    private Chips chips;

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
    public Chips payAChip(int i) {
        return this.chips.giveChips(i);
    }

    @Override
    public void gainChips(Chips chips) {
        this.chips.addChips(chips);
    }
}
