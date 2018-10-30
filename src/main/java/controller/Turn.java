package controller;

import domain.Betting;
import domain.BettingChecker;
import domain.Dealer;
import domain.Player;
import dto.BettingDto;
import dto.TurnOverDto;
import jdk.internal.util.xml.impl.Input;
import view.InputView;
import vo.BettingCase;

public class Turn {

    static void initTurn(Player p1, Player p2, Dealer dealer) {
        // 제로

        // dealer.judgeTurn(firstTurn(Player p1, Player p2, BettingDto p1BettingDto, BettingDto p2BettingDto));
    }

    static TurnOverDto firstTurn(Player p1, Player p2, BettingDto p1BettingDto, BettingDto p2BettingDto) {
        BettingCase bettingCase = InputView.inputBettingCase();

        int chipsNum = decideChipNums(p1BettingDto, p2BettingDto, bettingCase);

        Betting p1Betting = p1.firstBetting(chipsNum, bettingCase, p1BettingDto);
        p1BettingDto = p1Betting.toDto();

        if (BettingChecker.isProgress(p1BettingDto)) return run(p1, p2, p1BettingDto, p2BettingDto);
        return new TurnOverDto(p1BettingDto, p2BettingDto);
    }

    static TurnOverDto run(Player p1, Player p2, BettingDto p1BettingDto, BettingDto p2BettingDto) {
        return null;
    }

    static int decideChipNums(BettingDto p1BettingDto, BettingDto p2BettingDto, BettingCase bettingCase) {
        if(bettingCase.equals(BettingCase.CALL_CASE)){
            return BettingChecker.numberOfCallChips(p1BettingDto,p2BettingDto);
        }
        if(bettingCase.equals(BettingCase.RAISE_CASE)){
            int chipsNum = InputView.inputChip();
            while(chipsNum <= BettingChecker.numberOfCallChips(p1BettingDto, p2BettingDto)) {
                chipsNum = InputView.inputChip();
            }
            return chipsNum;
        }
        return 0;
    }
}