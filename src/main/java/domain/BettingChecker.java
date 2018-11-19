package domain;

import dto.BettingDto;
import vo.BettingCase;

public class BettingChecker {

    // call, die 일 때 false return. 이 때 턴을 종료해야함. 레이즈일 때 유효한
    public static boolean isProgress(BettingDto bettingDto) {
        return bettingDto.getBettingCase().equals(BettingCase.RAISE_CASE);
    }

    public static int numberOfCallChips(BettingDto myBettingDto, BettingDto otherBettingDto){
        return otherBettingDto.getChips().minus(myBettingDto.getChips()).getChips();
    }

}
