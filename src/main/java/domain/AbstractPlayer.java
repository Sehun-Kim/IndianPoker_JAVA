package domain;

import vo.Card;
import vo.Chip;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPlayer implements Player {

    public static final int FIRST = 0;
    private String name;
    private List<Chip> chips;
    private Deck deck;

    protected AbstractPlayer(String name, List<Chip> chips) {
        this.chips = chips;
        this.name = checkName(name);
        this.deck = new Deck();
    }

    private String checkName(String name) {
        if(name.length() > NAME_LENGTH)
            throw new IllegalArgumentException("이름의 길이가 너무 깁니다.");
        if(name.length() == 0)
            throw new IllegalArgumentException("이름의 길이가 너무 짧습니다.");
        return name;
    }

    @Override
    public Card giveACard(){
        return this.deck.giveCard();
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public List<Chip> getChips(int numberOfChips){
        if(numberOfChips > this.chips.size()) throw new IllegalArgumentException();

        List<Chip> bettingChips = new ArrayList<>();
        for (int i = 0; i < numberOfChips; i++){
            bettingChips.add(this.chips.remove(FIRST));
        }
        return bettingChips;
    }
}
