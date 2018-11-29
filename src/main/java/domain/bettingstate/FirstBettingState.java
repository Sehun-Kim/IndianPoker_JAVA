package domain.bettingstate;

import domain.Betting;
import dto.BettingDto;
import vo.BettingCase;
import vo.Chips;

public class FirstBettingState extends AbstractBettingState {
    public FirstBettingState(BettingDto bettingDto) {
        super(bettingDto);
    }

    @Override
    public BettingState changeState(Chips remainChips, BettingDto bettingDto) {
        if (remainChips.isZero()) return new IdiotBettingState(bettingDto);
        return new GeneralBettingState(bettingDto);
    }

    @Override
    public Betting betting(Chips chips, BettingCase bettingCase) {
        return Betting.ofFirst(chips, bettingCase, this.bettingDto);
    }
}
