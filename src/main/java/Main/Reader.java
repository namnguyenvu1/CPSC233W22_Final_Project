package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
    public static ManagerDocument loadDocument(File file) throws FileNotFoundException {
        //Create World object newWorld
        ManagerDocument managerDocument = new ManagerDocument();
        List<Document> lstDocuments = new ArrayList<Document>();
        //Try to scan with throwing an exception
        if (file.exists()) {
//            managerDocument = new ManagerDocument();
            Scanner scan = new Scanner(file);
            String line = scan.nextLine();
            //Take out 2 number to find how many lines needed to loop through
            int numberOfLine = Integer.parseInt(line);
            for (int i = 1; i < numberOfLine + 1; i++) {
                line = scan.nextLine();
                //Split the words
                String[] integers = line.split(",");
                //Add to document
                Document driver = new Players(integers[0].trim(), integers[1].trim(), Integer.parseInt(integers[2].trim()), Integer.parseInt(integers[3].trim()), Integer.parseInt(integers[4].trim()), Integer.parseInt(integers[5].trim()), integers[6].trim());
                lstDocuments.add(driver);
//                managerDocument.addPlayers(driver);
            }
        }
        managerDocument.documents = lstDocuments;
        return managerDocument;
    }
}
