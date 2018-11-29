package domain.bettingstate;

import domain.Betting;
import dto.BettingDto;
import vo.BettingCase;
import vo.Chips;

public class IdiotBettingState extends AbstractBettingState {
    public IdiotBettingState(BettingDto bettingDto) {
        super(bettingDto);
    }

    @Override
    public BettingState changeState(Chips remainChips, BettingDto bettingDto) {
        return null;
    }

    @Override
    public Betting betting(Chips chips, BettingCase bettingCase) {
        return null;
    }
}
