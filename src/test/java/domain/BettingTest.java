package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class BettingTest {

    @Test
    public void init() {
        Betting tmp = Betting.fistBetting(1, "sehun");

        System.out.println(tmp);
        assertEquals(Betting.fistBetting(1, "k"), tmp);
//        assertEquals(Betting.init(4), new IllegalArgumentException());
    }

}