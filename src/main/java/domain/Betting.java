package domain;

import dto.BettingDto;
import vo.BettingCase;
import vo.Chip;

import java.util.List;

public class Betting {
    List<Chip> chips;
    BettingCase bettingCase;
    String name;

    private Betting(List<Chip> chips, BettingCase bettingCase, String name) {
        this.chips = chips;
        this.bettingCase = bettingCase;
        this.name = name;
    }

    public static Betting ofFirst(List<Chip> chips, BettingCase bettingCase, String name) {
        if(bettingCase.equals(BettingCase.CALL_CASE))
            throw new IllegalArgumentException("첫 배팅에는 CALL할 수 없습니다.");
        return new Betting(chips, bettingCase, name);
    }

    public static Betting ofGeneral(BettingDto preBettingDto, BettingCase bettingCase, List<Chip> chips) {
        return new Betting(chips, bettingCase, preBettingDto.getName());
    }

    public BettingDto toDto() {
        return new BettingDto(this.chips, this.bettingCase, this.name);
    }


}
