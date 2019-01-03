package indianpoker.controller;

import indianpoker.domain.Dealer;
import indianpoker.domain.betting.BettingTable;
import indianpoker.domain.player.Player;
import indianpoker.dto.TurnResultDto;
import indianpoker.exception.CanNotCallCaseException;
import indianpoker.exception.EmptyChipException;
import indianpoker.view.InputView;
import indianpoker.view.ResultView;
import indianpoker.vo.BettingCase;
import indianpoker.vo.Chips;
import support.util.ChipExtractorUtil;

// 너는 게임의 한판이야
// 승패를 판단한 다음에 스테이트도 판단해야할 듯
public class Turn {
    public static void start(Player player1, Player player2, Dealer dealer) {
        dealer.drawPlayerCards(player1, player2); // 뷰에 상대 카드가 뭔지 보여줄 것을 리턴
        BettingTable bettingTable = new BettingTable();
        ChipExtractorUtil.addAllBettingChips(player1.initTurn(), player2.initTurn(), bettingTable);
        TurnResultDto turnResultDto = TurnResultDto.of();
        try {
            turnResultDto = orderToRun(player1, player2, bettingTable, dealer);
        } catch (EmptyChipException e) {
            turnResultDto = dealer.judgeCallCase(player1, player2, bettingTable.calcWinningChips());
        } finally {
            ResultView.showTurnResult(turnResultDto);
            dealer.checkGameOver(player1, player2);
        }

    }

    static TurnResultDto firstRun(Player better, Player otherPlayer, BettingTable bettingTable, Dealer dealer) {
        checkEmptyChipException(better.showChips(), otherPlayer.showChips());
        return run(better, otherPlayer, bettingTable, dealer);
    }

    static TurnResultDto run(Player better, Player otherPlayer, BettingTable bettingTable, Dealer dealer) {
        ResultView.showBettingInfo(dealer.generateBettingInfo(better, bettingTable));

        BettingCase bettingCase = InputView.inputBettingCase();

        if (bettingCase.equals(BettingCase.DIE_CASE)) {
            return bettingDieCase(better, otherPlayer, bettingTable, dealer, bettingCase);
        }
        if (bettingCase.equals(BettingCase.CALL_CASE)) {
            return bettingCallCase(better, otherPlayer, bettingTable, dealer, bettingCase);
        }
        //raiseBetting
        return bettingRaiseCase(better, otherPlayer, bettingTable, dealer, bettingCase);

    }

    private static TurnResultDto bettingRaiseCase(Player better, Player otherPlayer, BettingTable bettingTable, Dealer dealer, BettingCase bettingCase) {
        if (otherPlayer.showChips().isEmpty()) {
            System.out.println("상대가 올인하여 Raise가 불가합니다.");
            return run(better, otherPlayer, bettingTable, dealer);
        }
        Chips chips = InputView.inputChip(bettingTable.calcDiffChips(), better.showChips(), otherPlayer.showChips());
        ChipExtractorUtil.addBettingChips(better.betting(better.payChips(chips), bettingCase), bettingTable);
        return run(otherPlayer, better, bettingTable, dealer);
    }

    private static TurnResultDto bettingCallCase(Player better, Player otherPlayer, BettingTable bettingTable, Dealer dealer, BettingCase bettingCase) {
        Chips chips = bettingTable.calcDiffChips();
        try {
            ChipExtractorUtil.addBettingChips(better.betting(better.payChips(chips), bettingCase), bettingTable);
        } catch (CanNotCallCaseException e) {
            return run(better, otherPlayer, bettingTable, dealer);
        }

        return dealer.judgeCallCase(better, otherPlayer, bettingTable.calcWinningChips());
    }

    private static TurnResultDto bettingDieCase(Player better, Player otherPlayer, BettingTable bettingTable, Dealer dealer, BettingCase bettingCase) {
        ChipExtractorUtil.addBettingChips(better.betting(Chips.ofZero(), bettingCase), bettingTable);
        return dealer.judgeDieCase(better, otherPlayer, bettingTable.calcWinningChips());
    }

    private static TurnResultDto orderToRun(Player player1, Player player2, BettingTable bettingTable, Dealer dealer) {
        if (player1.isFirst())
            return firstRun(player1, player2, bettingTable, dealer);

        return firstRun(player2, player1, bettingTable, dealer);
    }

    private static void checkEmptyChipException(Chips player1Chips, Chips player2Chips) {
        if (player1Chips.isEmpty() || player2Chips.isEmpty()) {
            throw new EmptyChipException("chip is empty"
                    + System.lineSeparator()
                    + "player1 :"
                    + player1Chips + " player2 : " + player2Chips);
        }
    }

    // 게임start
    // 지금 문제는 배팅할때 케이스를 먼저 입력하고 그에 따라 칩수를 결정해야하는데 인풋을 어디에서 받아야 할지가 문제다.
}
