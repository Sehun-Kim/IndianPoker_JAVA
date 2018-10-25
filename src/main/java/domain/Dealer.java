package domain;

import domain.Deck;
import vo.Chip;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Dealer {

    private Map<Player, Deck> map;

    private Deck player1Deck;
    private Deck player2Deck;

    public Dealer() {
        this.player1Deck = new Deck();
        this.player2Deck = new Deck();
    }

    public List<Chip> giveInitChips(int numberOfChips) {
        List<Chip> chips = new ArrayList<>();
        for (int i = 0; i < numberOfChips; i++) {
            chips.add(new Chip());
        }
        return chips;
    }


}
