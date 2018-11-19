package domain;

import dto.TurnOverDto;

@FunctionalInterface
public interface Judgeable {
    void judging(Player player1, Player player2, TurnOverDto turnOverDto);
}
