import java.util.*;

public class cellStats {
    //dps
    public static int dps(List<? extends Cell> cells) {
        return cells.stream()
                    .mapToInt(Cell::getDamage)
                    .sum();
    }

    //no. of each cell

}
