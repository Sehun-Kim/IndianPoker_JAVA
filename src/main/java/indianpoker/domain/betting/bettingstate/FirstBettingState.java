package indianpoker.domain.betting.bettingstate;

import indianpoker.domain.player.Player;
import indianpoker.exception.CanNotCallCaseException;
import indianpoker.vo.BettingCase;
import indianpoker.vo.Chips;

public class FirstBettingState extends AbstractBettingState {

    public FirstBettingState(Chips chips, BettingCase bettingCase, Player player) {
        super(chips, bettingCase, player);
        if (bettingCase.equals(BettingCase.CALL_CASE))
            throw new CanNotCallCaseException("첫 베팅은 콜할 수 없습니다.");
    }

    @Override
    public BettingState betting(Chips chips, BettingCase bettingCase) {
        return createGeneralBettingState(chips, bettingCase);
    }


}
