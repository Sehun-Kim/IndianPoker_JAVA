package domain;

import vo.Betting;
import vo.Chip;

import java.util.List;

public class HumanPlayer extends AbstractPlayer {

    public HumanPlayer(String name, List<Chip> chips){
        super(name, chips);
    }

    @Override
    public Betting firstBetting(int chip) {
        return null;
    }

    @Override
    public Betting betting(int chip, Betting myBetting) {
        return null;
    }


}
