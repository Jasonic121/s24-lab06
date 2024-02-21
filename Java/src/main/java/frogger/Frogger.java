package frogger;

/**
 * Refactor Task 1 & 2: Frogger
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22), Duan Liang (F23)
 */
public class Frogger {

    // Field for task 1.
    private final Road road;
    private int position;
    
    // Field for task 2. Anything to add/change?
    private final Records records;
    private final FroggerID froggerID;


    public Frogger(Road road, int position, Records records, FroggerID froggerID) {
        this.road = road;
        this.position = position;
        this.records = records;
        this.froggerID = froggerID;
    }

    /**
     * Moves Frogger.
     *
     * @param forward true is move forward, else false.
     * @return true if move successful, else false.
     */
    public boolean move(boolean forward) {
        int nextPosition = this.position + (forward ? 1 : -1);
        // if (!isValid(nextPosition) || isOccupied(nextPosition)) {
        if (!road.isValidPosition(nextPosition) || road.isOccupied(nextPosition)) {
        return false;
        }
        this.position = nextPosition;
        return true;
    }

    // TODO: Do you notice any issues here?
    // Feature Envy: This method is more interested in the Road class than the Frogger class.
    // Inappropriate Intimacy: This method is using the Road class more than the Frogger class.
    // public boolean isOccupied(int position) {
    //     boolean[] occupied = this.road.getOccupied();
    //     return occupied[position];
    // }
    
    // public boolean isValid(int position) {
    //     if (position < 0) return false;
    //     boolean[] occupied = this.road.getOccupied();
    //     return position < occupied.length;
    // }

    // Primitive Obsession: This method is using primitive types to represent a concept.
    /**
     * Records Frogger to the list of records.
     * 
     * @return true if record successful, else false.
     */
    public boolean recordMyself() {
        boolean success = records.addRecord(froggerID);
        return success;
      }

}
