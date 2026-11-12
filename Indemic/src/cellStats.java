import java.util.*;

public class cellStats {
    //dps
    public static int dps(List<? extends Cell> cells) {
        return cells.stream()
                    .mapToInt(Cell::getDamage) //Dosen't take into modifiers like critical strieks
                    .sum();
    }

    //no. of each cell

}
