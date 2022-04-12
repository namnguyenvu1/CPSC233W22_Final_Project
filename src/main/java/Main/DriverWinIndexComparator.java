package Main;

import java.util.Comparator;

public class DriverWinIndexComparator implements Comparator<Document> {
    @Override
    public int compare(Document o1, Document o2) {
        if (o1.getWins() < o2.getWins()) {
            return 1;
        }
        if (o1.getWins() > o2.getWins()) {
            return -1;
        }
        return 0;
    }
}
