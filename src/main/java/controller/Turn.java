package controller;

import domain.Betting;
import domain.BettingChecker;
import domain.Dealer;
import domain.Player;
import dto.BettingDto;
import dto.TurnOverDto;
import view.InputView;
import view.ResultView;
import vo.BettingCase;

public class Turn {

    // 1 | 1
    public static void startTurn(Player p1, Player p2, Dealer dealer) {
//        p1.drawACard();
//        p2.drawACard();
//        TurnOverDto turnOverDto = startOrder(p1, p2, p1.zeroBetting().toDto(), p2.zeroBetting().toDto());
//        System.out.println(turnOverDto);
//
//        dealer.judgeTurn(p1, p2, turnOverDto);
    }

    // 1 | 1 | 2 | ?
    static TurnOverDto startOrder(Player p1, Player p2, BettingDto p1BettingDto, BettingDto p2BettingDto) {
//        ResultView.showOpositPlayerStatus(p2.toDto());
//        BettingCase bettingCase = InputView.inputBettingCase();
//
//        int chipsNum = decideChipNums(p1BettingDto, p2BettingDto, bettingCase);
//
//        Betting p1Betting = p1.firstBetting(chipsNum, bettingCase, p1BettingDto);
//        p1BettingDto = p1Betting.toDto();
//
//        return run(p1, p2, p1BettingDto, p2BettingDto);
    }

    static TurnOverDto run(Player p1, Player p2, BettingDto p1BettingDto, BettingDto p2BettingDto) {
//        if (!BettingChecker.isProgress(p1BettingDto))
//            return new TurnOverDto(p1BettingDto, p2BettingDto);
//
//        ResultView.showOpositPlayerStatus(p1.toDto());
//        BettingCase bettingCase = InputView.inputBettingCase();
//        int chipsNum = decideChipNums(p2BettingDto, p1BettingDto, bettingCase);
//
//        Betting p2Betting = p2.generalBetting(chipsNum, bettingCase, p2BettingDto);
//        p2BettingDto = p2Betting.toDto();
//
//        return run(p2, p1, p2BettingDto, p1BettingDto);
    }

    static int decideChipNums(BettingDto p1BettingDto, BettingDto p2BettingDto, BettingCase bettingCase) {
        if (bettingCase.equals(BettingCase.CALL_CASE)) {
            return BettingChecker.numberOfCallChips(p1BettingDto, p2BettingDto);
        }
        if (bettingCase.equals(BettingCase.RAISE_CASE)) {
            int chipsNum = InputView.inputChip();
            while (chipsNum <= BettingChecker.numberOfCallChips(p1BettingDto, p2BettingDto)) {
                chipsNum = InputView.inputChip();
            }
            return chipsNum;
        }
        return 0;
    }
}