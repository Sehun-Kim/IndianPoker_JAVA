package dto;

import domain.Deck;
import vo.Card;
import vo.Chips;

public class PlayerDto {
    private String name;
    private Chips chips;
    private Card card;

    public PlayerDto(String name, Chips chips, Card card) {
        this.name = name;
        this.chips = chips;
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Chips getChips() {
        return chips;
    }

    public void setChips(Chips chips) {
        this.chips = chips;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "PlayerDto{" +
                "name='" + name + '\'' +
                ", chips=" + chips +
                ", card=" + card +
                '}';
    }
}
