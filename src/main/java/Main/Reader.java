package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
    public static List<Document> loadDocument(File fileWorld) throws FileNotFoundException {
        //Create World object newWorld
        List<Document> documents = null;
        List<Document> lstDocuments = new ArrayList<Document>();
        //Try to scan with throwing an exception
        if (fileWorld.exists()) {
            Scanner scan = new Scanner(fileWorld);
            String line = scan.nextLine();
            //Take out 2 number to find how many lines needed to loop through
            int numberOfLine = Integer.parseInt(line);
            for (int i = 1; i < numberOfLine + 1; i++) {
                line = scan.nextLine();
                //Split the words
                String[] integers = line.split(",");
                //Add to document
                Document driver = new Players(integers[0], integers[1], Integer.parseInt(integers[2]), Integer.parseInt(integers[3]), Integer.parseInt(integers[4]), Integer.parseInt(integers[5]), integers[6]);
                lstDocuments.add(driver);
            }
        }
        documents.addAll(lstDocuments);
        return documents;
    }
}
