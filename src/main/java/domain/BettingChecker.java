package domain;

import dto.BettingDto;
import vo.BettingCase;

class BettingChecker {

    // call, die 일 때 false return. 이 때 턴을 종료해야함. 레이즈일 때 유효한
    static boolean isProgress(BettingDto toDto) {
        return toDto.getBettingCase().equals(BettingCase.RAISE_CASE);
    }

    static void checkCall(BettingDto myBetting, BettingDto otherBetting){

    }
}
