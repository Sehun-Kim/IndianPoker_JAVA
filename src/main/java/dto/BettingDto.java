package dto;

import vo.BettingCase;
import vo.Card;
import vo.Chip;

import java.util.List;

public class BettingDto {

    //    Card card;
    List<Chip> chips;
    BettingCase bettingCase;
    String name;

    public BettingDto(List<Chip> chips, BettingCase bettingCase, String name) {
        this.chips = chips;
        this.bettingCase = bettingCase;
        this.name = name;
    }

    public List<Chip> getChips() {
        return chips;
    }

    public BettingCase getBettingCase() {
        return bettingCase;
    }

    public String getName() {
        return name;
    }
}
