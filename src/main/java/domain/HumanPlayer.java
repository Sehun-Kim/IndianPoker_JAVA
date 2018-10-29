package domain;

import dto.BettingDto;
import vo.BettingCase;
import vo.Chips;

import java.util.List;

public class HumanPlayer extends AbstractPlayer {

    public HumanPlayer(String name, Chips chips) {
        super(name, chips);
    }

    @Override
    public Betting firstBetting(int numberOfChips, BettingCase bettingCase, BettingDto preBettingDto) {
        return Betting.ofFirst(getChips(numberOfChips), bettingCase, preBettingDto);
    }

    @Override
    public Betting generalBetting(int numberOfChips, BettingCase bettingCase, BettingDto preBettingDto) {
        return Betting.ofGeneral(getChips(numberOfChips), bettingCase, preBettingDto);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
