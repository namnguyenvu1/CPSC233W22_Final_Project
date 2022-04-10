package Main;

import java.util.Comparator;

public class DriverNameComparator implements Comparator<Document> {
    @Override
    public int compare(Document o1, Document o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
