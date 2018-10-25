package domain;

import vo.BettingCase;
import vo.Chip;

import java.util.List;

public class HumanPlayer extends AbstractPlayer {

    public HumanPlayer(String name, List<Chip> chips) {
        super(name, chips);
    }

    @Override
    public Betting firstBetting(int numberOfChips, BettingCase bettingCase) {
        if(bettingCase.equals(BettingCase.DIE_CASE)){
            return Betting.ofFirst(getChips(1), bettingCase, this.getName());
        }
        return Betting.ofFirst(getChips(numberOfChips + 1), bettingCase, this.getName());
    }

    @Override
    public Betting generalBetting(int numberOfChips, Betting myBetting) {
        return null;
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
