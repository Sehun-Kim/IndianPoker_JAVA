package domain.bettingstate;

import dto.BettingDto;

public abstract class AbstractBettingState implements BettingState {
    protected BettingDto bettingDto;

    public AbstractBettingState(BettingDto bettingDto) {
        this.bettingDto = bettingDto;
    }

}
