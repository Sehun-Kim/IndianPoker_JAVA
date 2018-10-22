package domain;

import vo.Betting;
import vo.Card;
import vo.Chip;

import java.util.List;

public abstract class AbstractPlayer implements Player {

    private String name;
    private List<Chip> chips;
    protected Card card;

    protected AbstractPlayer(String name, List<Chip> chips) {
        this.chips = chips;
        this.name = checkName(name);
    }

    private String checkName(String name) {
        if(name.length() > NAME_LENGTH)
            throw new IllegalArgumentException("이름의 길이가 너무 깁니다.");
        if(name.length() == 0)
            throw new IllegalArgumentException("이름의 길이가 너무 짧습니다.");
        return name;
    }

    @Override
    public String getName(){
        return this.name;
    }

}
