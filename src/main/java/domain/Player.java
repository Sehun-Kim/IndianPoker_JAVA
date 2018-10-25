package domain;

import vo.BettingCase;
import vo.Card;
import vo.Chip;

import java.util.List;

public interface Player {

    int NAME_LENGTH = 8;

    Betting firstBetting(int numberOfChips, BettingCase bettingCase);

    Betting generalBetting(int numberOfChips, Betting myBetting);

    String getName();

    Card giveACard();

    List<Chip> getChips(int numberOfChips);
}
