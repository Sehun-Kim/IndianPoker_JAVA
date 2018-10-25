package domain;

        import org.junit.Test;
        import vo.BettingCase;
        import vo.Chip;

        import java.util.Arrays;
        import java.util.List;

        import static org.junit.Assert.*;

public class BettingTest {

    @Test
    public void initFirstTest() {
        List<Chip> chips = Arrays.asList(new Chip(), new Chip());
        Betting betting = Betting.ofFirst(chips, BettingCase.DIE_CASE, "choising");
    }

    @Test (expected = IllegalArgumentException.class)
    public void initFirstErrorTest() {
        List<Chip> chips = Arrays.asList(new Chip(), new Chip());
        Betting betting = Betting.ofFirst(chips, BettingCase.CALL_CASE, "choising");
    }

    @Test
    public void initBetting() {
        List<Chip> chips = Arrays.asList(new Chip(), new Chip());
        Betting betting1 = Betting.ofFirst(chips, BettingCase.RAISE_CASE, "choising");
        Betting betting = Betting.ofGeneral(betting1.toDto(), BettingCase.RAISE_CASE, chips);
    }
}