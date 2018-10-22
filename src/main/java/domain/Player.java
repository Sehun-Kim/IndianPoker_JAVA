package domain;

import vo.Betting;

public interface Player {

    int NAME_LENGTH = 8;

    Betting firstBetting(int chip);

    Betting betting(int chip, Betting myBetting);


    String getName();
}
