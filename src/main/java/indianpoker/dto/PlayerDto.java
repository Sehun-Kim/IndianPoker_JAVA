package indianpoker.dto;

import indianpoker.vo.Chips;

public class PlayerDto {
    private String name;
    private Chips remainChips;

    public PlayerDto(String name, Chips remainChips) {
        this.name = name;
        this.remainChips = remainChips;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PlayerDto{" +
                "name='" + name + '\'' +
                ", remainChips=" + remainChips +
                '}';
    }
}
