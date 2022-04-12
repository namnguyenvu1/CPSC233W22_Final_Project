package Main;

import java.util.Comparator;

public class BestDriverComparator implements Comparator<Document> {
    /**
     * This is interface Comparator to sort drivers by their performance
     * @param o1
     * @param o2
     * @return 1 if Document o1 should be after Document o2
     *         0 if Document o1 is equal to Document o2
     *         -1 Document o1 should be before Document o2
     */
    @Override
    public int compare(Document o1, Document o2) {
        if ((100 * o1.getWins()/o1.getRaces()) < (100 * o2.getWins()/o2.getRaces())) {
            return 1;
        }
        if ((100 * o1.getWins()/o1.getRaces()) > (100 * o2.getWins()/o2.getRaces())) {
            return -1;
        }
        return 0;
    }
}
