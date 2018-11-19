package domain;

import dto.PlayerDto;
import vo.Card;
import vo.Chips;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPlayer implements Player {

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

    private Card giveACard() {
        return this.deck.giveCard();
    }

    @Override
    public void addChips(Chips totalChips) {
        this.chips = this.chips.add(totalChips);
    }

    @Override
    public PlayerDto toDto(){
        return new PlayerDto(this.name, this.chips, this.card);
    }

    @Override
    public Betting zeroBetting() {
        this.card = this.giveACard();
        return Betting.ofZero(getChips(1), this.name);
    }

    @Override
    public String getName() {
        return this.name;
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
