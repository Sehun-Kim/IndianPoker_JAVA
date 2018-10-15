package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class GamerTest {

    @Test
    public void init() {
        Gamer g1 = Gamer.initGamer("sehun");
        System.out.println(g1);
    }

    @Test
    public void betting() {
        Gamer g1 = Gamer.initGamer("sehun");
        Betting oppositeBetting = Betting.fistBetting(1, "enemy");
        Betting myBetting = Betting.firstBetting()
        g1.betting(2,)


    }

}