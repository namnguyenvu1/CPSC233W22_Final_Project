package Main;

import java.util.Comparator;

public class BestDriverComparator implements Comparator<Document> {
    @Override
    public int compare(Document o1, Document o2) {
        if ((o1.getWins()/o1.getRaces()) < (o2.getWins()/o2.getRaces())) {
            return 1;
        }
        if ((o1.getWins()/o1.getRaces()) > (o2.getWins()/o2.getRaces())) {
            return -1;
        }
        return 0;
    }
}
