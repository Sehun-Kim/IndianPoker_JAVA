package domain;

import domain.bettingstate.BettingState;
import domain.bettingstate.ZeroBettingState;
import dto.BettingDto;
import dto.PlayerDto;
import vo.BettingCase;
import vo.Card;
import vo.Chips;

public abstract class AbstractPlayer implements Player {
    private BettingState bettingState;

    public static final int FIRST = 0;
    private String name;
    private Chips chips;
    private Deck deck;
    private Card card;

    protected AbstractPlayer(String name, Chips chips) {
        this.chips = chips;
        this.name = checkName(name);
        this.deck = new Deck();
    }

    private String checkName(String name) {
        if (name.length() > NAME_LENGTH)
            throw new IllegalArgumentException("이름의 길이가 너무 깁니다.");
        if (name.length() == 0)
            throw new IllegalArgumentException("이름의 길이가 너무 짧습니다.");
        return name;
    }

    public Betting betting(int numberOfChips, BettingCase bettingCase, BettingDto preBettingDto) {
        Betting newBetting =  bettingState.betting(getChips(numberOfChips), bettingCase);
        this.bettingState = bettingState.changeState(this.chips, newBetting.toDto());
        return newBetting;
    }

    @Override
    public void prepareTurn() {
        this.card = this.deck.giveCard();
        this.bettingState = new ZeroBettingState(new BettingDto(new Chips(0), BettingCase.NONE_CASE, this.name));
    }

    @Override
    public void addChips(Chips totalChips) {
        this.chips = this.chips.add(totalChips);
    }

    @Override
    public PlayerDto toDto() {
        return new PlayerDto(this.name, this.chips, this.card);
    }


    @Override
    public Chips getChips(int numberOfChips) {
        Chips otherChips = new Chips(numberOfChips);
        this.chips = this.chips.minus(otherChips);
        return otherChips;
    }

    @Override
    public String toString() {
        return "AbstractPlayer{" +
                "name='" + name + '\'' +
                ", chips=" + chips +
                ", deck=" + deck +
                '}';
    }
}
