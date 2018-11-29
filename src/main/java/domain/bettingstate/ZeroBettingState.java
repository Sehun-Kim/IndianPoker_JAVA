package domain.bettingstate;

import domain.Betting;
import dto.BettingDto;
import vo.BettingCase;
import vo.Chips;

public class ZeroBettingState extends AbstractBettingState {

    public ZeroBettingState(BettingDto bettingDto) {
        super(bettingDto);
    }

    @Override
    public BettingState changeState(Chips remainChips, BettingDto bettingDto) {
        if(remainChips.isZero()) return new IdiotBettingState(bettingDto);
        return new FirstBettingState(bettingDto);
    }

    @Override
    public Betting betting(Chips chips, BettingCase bettingCase) {
        return Betting.ofZero(chips, this.bettingDto.getName());
    }

}
