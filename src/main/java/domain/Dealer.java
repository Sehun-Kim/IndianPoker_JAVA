package domain;

import dto.TurnOverDto;

import java.util.HashMap;
import java.util.Map;

public class Dealer {
    static Map<Integer, Judgeable> map = new HashMap<>();
    static {
        map.put(0, (player1, player2, turnOverDto) -> {
                    player1.addChips(turnOverDto.getHalfChips());
                    player2.addChips(turnOverDto.getHalfChips());
                });
        map.put(1, (player1, player2, turnOverDto) -> {
            player1.addChips(turnOverDto.getTotalChips());
        });
        map.put(-1, (player1, player2, turnOverDto) -> {
            player2.addChips(turnOverDto.getTotalChips());
        });
    }

    public void judgeTurn(Player p1, Player p2, TurnOverDto turnOverDto) {
        map.get(p1.toDto().getCard().compareTo(p2.toDto().getCard())).judging(p1, p2, turnOverDto);
    }

}
