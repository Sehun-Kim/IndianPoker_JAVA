package indianpoker.domain;

import indianpoker.domain.player.Player;
import indianpoker.dto.BettingInfoDto;
import indianpoker.vo.Card;
import indianpoker.vo.Chips;
import org.junit.Before;
import org.junit.Test;
import support.Fixture;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class DealerTest extends Fixture {
    private Dealer testDealer = new Dealer();;

    @Before
    public void setUp() {
        Map<Player, Card> map =  testDealer.receivePlayerCards(player1, player2);
        for (Card card : map.values()) {
            System.out.println(card);
        }
        testDealer.drawPlayerCards(map);
    }

    @Test
    public void getPlayerCard() {
        testDealer.drawPlayerCards(player1, player2);
        System.out.println(testDealer.getPlayerCard(player1));
        System.out.println(testDealer.getPlayerCard(player2));
    }

    private void settingCards(int p1Card, int p2Card){
        Map<Player, Card> playerCards = new HashMap<>();
        playerCards.put(player1, new Card(p1Card));
        playerCards.put(player2, new Card(p2Card));
        dealer.drawPlayerCards(playerCards);
    }

    @Test
    public void judge_turn_draw() {
        settingCards(1,1);

        Chips p1CurChip = player1.showChips();
        Chips p2CurChip = player2.showChips();

        System.out.println(dealer.judgeCallCase(player1, player2, Chips.ofNumberOfChips(2)));
        assertEquals(p1CurChip.addChips(Chips.ofNumberOfChips(1)), player1.showChips());
        assertEquals(p2CurChip.addChips(Chips.ofNumberOfChips(1)), player2.showChips());
    }

    @Test
    public void judge_turn_p1win() {
        settingCards(5,1);

        Chips p1CurChip = player1.showChips();
        Chips p2CurChip = player2.showChips();

        System.out.println(dealer.judgeCallCase(player1, player2, Chips.ofNumberOfChips(5)));
        assertEquals(p1CurChip.addChips(Chips.ofNumberOfChips(5)), player1.showChips());
        assertEquals(p2CurChip, player2.showChips());
    }


    @Test
    public void judge_turn_p2win() {
        settingCards(1,5);

        Chips p1CurChip = player1.showChips();
        Chips p2CurChip = player2.showChips();

        System.out.println(dealer.judgeCallCase(player1, player2, Chips.ofNumberOfChips(5)));
        assertEquals(p1CurChip, player1.showChips());
        assertEquals(p2CurChip.addChips(Chips.ofNumberOfChips(5)), player2.showChips());
    }

    @Test
    public void generateBettingInfo() {
        BettingInfoDto bettingInfoDto = testDealer.generateBettingInfo(player1, bettingTable);
        assertEquals(bettingInfoDto.getOwnBetterDto().getName(), "dom");
        System.out.println(bettingInfoDto);

    }
}