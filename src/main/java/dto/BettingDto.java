package dto;

import vo.BettingCase;
import vo.Chips;

import java.util.List;

public class BettingDto {

    //    Card card;
    Chips chips;
    BettingCase bettingCase;
    String name;

    public BettingDto(Chips chips, BettingCase bettingCase, String name) {
        this.chips = chips;
        this.bettingCase = bettingCase;
        this.name = name;
    }

    public Chips getChips() {
        return chips;
    }

    public BettingCase getBettingCase() {
        return bettingCase;
    }

    public String getName() {
        return name;
    }
}
