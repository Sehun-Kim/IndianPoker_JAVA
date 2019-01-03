package indianpoker.dto;

import indianpoker.vo.Chips;

public class BetterDto {
    private String name;
    private Chips remainChips;

    public BetterDto(String name, Chips remainChips) {
        this.name = name;
        this.remainChips = remainChips;
    }

    public String getName() {
        return name;
    }

    public Chips getRemainChips() {
        return remainChips;
    }

    @Override
    public String toString() {
        return "Better : " + name + System.lineSeparator() +
                "Chips : " + remainChips;
    }
}
