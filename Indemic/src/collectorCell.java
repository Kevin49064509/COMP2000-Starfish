public class collectorCell extends Cell {
    // Doing damage to boss will have resources come off which will be collected by these cells.
    @Override 
    public collectorCell(int damage, int cost) {
        super(damage, cost);
    }

}
