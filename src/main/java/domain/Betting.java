package domain;

import dto.BettingDto;
import vo.BettingCase;
import vo.Chips;

import java.util.ArrayList;
import java.util.List;

public class Betting {
    Chips chips;
    BettingCase bettingCase;
    String name;

    private Betting(Chips chips, BettingCase bettingCase, String name) {
        this.chips = chips;
        this.bettingCase = bettingCase;
        this.name = name;
    }

    public static Betting ofZero(Chips chips, String name) {
        return new Betting(chips, BettingCase.RAISE_CASE, name);
    }

    public static Betting ofFirst(Chips chips, BettingCase bettingCase, BettingDto preBettingDto) {
        if(bettingCase.equals(BettingCase.CALL_CASE))
            throw new IllegalArgumentException("첫 배팅에는 CALL할 수 없습니다.");
        Chips newChips = isValidDieChip(chips, bettingCase).add(preBettingDto.getChips());
        return new Betting(newChips, bettingCase, preBettingDto.getName());
    }

    public static Betting ofGeneral(Chips chips, BettingCase bettingCase, BettingDto preBettingDto) {
        Chips newChips = isValidDieChip(chips, bettingCase).add(preBettingDto.getChips());
        return new Betting(newChips, bettingCase, preBettingDto.getName());
    }

    private static Chips isValidDieChip(Chips chips, BettingCase bettingCase){
        if(bettingCase.equals(BettingCase.DIE_CASE) && chips.getChips() > 0)
            throw new IllegalArgumentException("DIE 일 때는 칩을 배팅할 수 없습니다.");
        return chips;
    }

    public BettingDto toDto() {
        return new BettingDto(this.chips, this.bettingCase, this.name);
    }

    @Override
    public String toString() {
        return "Betting{" +
                "chips=" + chips +
                ", bettingCase=" + bettingCase +
                ", name='" + name + '\'' +
                '}';
    }
}
