package domain.player;

import vo.Chips;

public interface Player {
    Chips showChips();
    Chips payChips(int i);
}
