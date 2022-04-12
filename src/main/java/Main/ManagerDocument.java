package Main;

import java.util.*;

public class ManagerDocument{
    List<Document> documents;
    public ManagerDocument managerDocument;

    public List<Document> getDocuments(){
        return documents;
    }

    public void addPlayers(Document players){
        List<Document> lstDocuments = new ArrayList<Document>();
        lstDocuments.add(players);
        documents.addAll(lstDocuments);
    }

    public ManagerDocument() {
        this.documents = new ArrayList<>();
    }

    public void addDocument(Document document) {
        this.documents.add(document);
    }

    public void addDocuments(List<Document> documents) {
        this.documents.addAll(documents);
    }

    public int getSize(){
        return documents.size();
    }

    public boolean deleteDocument(String id) {
        Document doc = this.documents.stream()
                .filter(document -> document.getName().equals(id))
                .findFirst().orElse(null);
        if (doc == null) {
            return false;
        }
        this.documents.remove(doc);
        return true;
    }

    public Document getPlayerByName(String name) {
        Document doc = this.documents.stream()
                .filter(document -> document.getName().equals(name))
                .findFirst().orElse(null);
        if (doc == null) {
            return null;
        }
        return doc;
    }

    public List<Document> top5Wins() {
        List<Document> top5Wins = new ArrayList<>();
        List<Document> top5WinsNew = new ArrayList<>();
        Collections.sort(documents, new DriverWinIndexComparator());
        top5Wins = documents;
        if (top5Wins.size() < 5){
           top5WinsNew = top5Wins;
        } else{
            for(int i = 0; i < 5; i++) {
                top5WinsNew.add(top5Wins.get(i));
            }
        }
        return top5WinsNew;
    }

    public List<Document> top5Fastest_Lap() {
        List<Document> top5FastestLap = new ArrayList<>();
        List<Document> top5FastestLapNew = new ArrayList<>();
        Collections.sort(documents, new DriverFastestLapComparator());
        top5FastestLap = documents;
        if (top5FastestLap.size() < 5){
            top5FastestLapNew = top5FastestLap;
        } else{
            for(int i = 0; i < 5; i++) {
                top5FastestLapNew.add(top5FastestLap.get(i));
            }
        }
        return top5FastestLapNew;
    }

    public List<Document> bestDriver() {
        List<Document> bestDriver = new ArrayList<>();
        List<Document> bestDriverNew = new ArrayList<>();
        Collections.sort(documents, new BestDriverComparator());
        bestDriver = documents;
        if (bestDriver.size() < 5){
            bestDriverNew = bestDriver;
        } else{
            for(int i = 0; i < 5; i++) {
                bestDriverNew.add(bestDriver.get(i));
            }
        }
        return bestDriverNew;
    }

    public List<Document> listByYear() {
        List<Document> listByYear = new ArrayList<>();
        List<Document> listByYearNew = new ArrayList<>();
        Collections.sort(documents, new DriverBirthYearComparator());
        listByYear = documents;
        for(int i = 0; i < 5; i++) {
            listByYearNew.add(listByYear.get(i));
        }
        return listByYearNew;
    }

    public void removeData() {
        Scanner scanner =  new Scanner(System.in);
        System.out.print("Enter id to remove: ");
        String id = scanner.nextLine();
        System.out.println(deleteDocument(id) ? "Success" : "Fail");
    }

    public void addNumberWin() {
        Scanner scanner =  new Scanner(System.in);
        System.out.print("Enter name to remove: ");
        String name = scanner.nextLine();
        Document player = getPlayerByName(name);
        if(player == null){
//            log err
            System.out.println("Error");
        } else{
            System.out.println("Enter win: ");
            int win = scanner.nextInt();
            player.setWins(win);
        }
    }

    public void addFastestLap() {
        String name = null;
        Scanner input1 = new Scanner(System.in);

        do{
            try {
                System.out.print("Enter the driver name: ");
                name = input1.nextLine();
                if(Character.isDigit(name.charAt(0))){
                    name = "";
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Invalid name");
            }
        }while(Objects.equals(name, ""));

        Document player = getPlayerByName(name);
        Integer fastest_laps = null;
        Scanner input = new Scanner(System.in);

        boolean validInput1 = false;
        do {
            System.out.println("How many fastest laps do you want to add? ");
            if (input.hasNextInt()){
                fastest_laps = input.nextInt();
                validInput1 = true;
            } else {
                System.out.println("You have entered incorrect input! Please enter a whole number only");
            }
            input.nextLine();
        } while (!validInput1 || Integer.toString(fastest_laps).equals("") || fastest_laps <= 0);

        if (getPlayerByName(name) != null) {
            int x = player.getFastestLaps();
            x = x + fastest_laps;
            player.setFastestLaps(x);
            System.out.println(name + "'s number of fastest laps has been updated to " + x);
        }
    }

    public void addNumberOfRaces() {
        String name = null;
        Scanner input1 = new Scanner(System.in);

        do {
            try {
                System.out.print("Enter the driver name: ");
                name = input1.nextLine();
                if (Character.isDigit(name.charAt(0))) {
                    name = "";
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Invalid name");
            }
        } while (Objects.equals(name, ""));

        Integer number_of_races = null;
        Scanner input = new Scanner(System.in);
        Document player = getPlayerByName(name);

        boolean validInput2 = false;
        do {
            System.out.println("How many number of races do you want to add? ");
            if (input.hasNextInt()) {
                number_of_races = input.nextInt();
                validInput2 = true;
            } else {
                System.out.println("You have entered incorrect input! Please enter a whole number only");
            }
            input.nextLine();
        } while (!validInput2 || Integer.toString(number_of_races).equals("") || number_of_races <= 0);

        if (getPlayerByName(name) != null) {
            int x = player.getRaces();
            x = x + number_of_races;
            player.setRaces(x);
            System.out.println(name + "'s number of number of races has been updated to " + x);
        }
    }

    public void updateNationality(){
        String name = null;
        Scanner input1 = new Scanner(System.in);

        do {
            try {
                System.out.print("Enter the driver name: ");
                name = input1.nextLine();
                if (Character.isDigit(name.charAt(0))) {
                    name = "";
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Invalid name");
            }
        } while (Objects.equals(name, ""));

        String nationality = null;
        Scanner input = new Scanner(System.in);
        Document player = getPlayerByName(name);

        do {
            try {
                System.out.print("Enter the driver's new nationality: ");
                nationality = input.nextLine();
                if (Character.isDigit(nationality.charAt(0))) {
                    nationality = "";
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Invalid name");
            }
        } while (Objects.equals(nationality, ""));

        if (getPlayerByName(name) != null) {
            player.setNationality(nationality);
            System.out.println(name + "'s nationality has been updated to " + nationality);
        }
    }

    public void updateBirthYear(){
        String name = null;
        Scanner input1 = new Scanner(System.in);

        do {
            try {
                System.out.print("Enter the driver name: ");
                name = input1.nextLine();
                if (Character.isDigit(name.charAt(0))) {
                    name = "";
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Invalid name");
            }
        } while (Objects.equals(name, ""));

        Integer birthYear = null;
        Scanner input = new Scanner(System.in);
        Document player = getPlayerByName(name);

        boolean validInput = false;
        do {
            System.out.print("Enter the driver's year of birth: ");
            if (input.hasNextInt()) {
                birthYear = input.nextInt();
                validInput = true;
            } else if (birthYear == null || birthYear <= 0) {
                System.out.println("You have entered incorrect input! Please enter a whole number only");
            } else {
                System.out.println("You have entered incorrect input! Please enter a whole number only");
            }
            input.nextLine();
        } while (!validInput || Integer.toString(birthYear).equals("") || birthYear <= 0);

        if (getPlayerByName(name) != null) {
            player.setBirthYear(birthYear);
            System.out.println(name + "'s birth year has been updated to " + birthYear);
        }
    }

    public String playerString(){
        String x = "";
        for (Document aDocument : documents) {
            x = x + "Name: " + aDocument.getName() +", Team: "+ aDocument.getTeam()+", Nationality: "
                    + aDocument.getNationality()+", No of Wins: " + aDocument.getWins() +", No of Races: "+ aDocument.getRaces()+", No of Fastest Laps: "
                    + aDocument.getFastestLaps()+", Birth Year: " + aDocument.getBirthYear() + "\n";
        }
        return x;
    }

    public String playerStringForTop5Wins(){
        String x = "";
        List<Document> top5Wins = top5Wins();
        for (Document aDocument : top5Wins) {
            x = x + aDocument.getName() + " from " + aDocument.getTeam() +" with " +aDocument.getWins() + " wins\n";
        }
        return x;
    }

    public String playerStringForDriverByFastestLap(){
        String x = "";
        List<Document> top5FastestLap = top5Fastest_Lap();
        for (Document aDocument : top5FastestLap) {
            x = x + aDocument.getName() + " from " + aDocument.getTeam() +" with "+ aDocument.getFastestLaps() + " fastest laps\n";
        }
        return x;
    }

    public String playerStringForBestDriver(){
        String x = "";
        List<Document> bestDriver = bestDriver();
        int wins;
        int races;
        int winPercentage;
        for (Document aDocument : bestDriver) {
            wins = aDocument.getWins();
            races = aDocument.getRaces();
            winPercentage = 100 * wins/races;
            x = x + aDocument.getName() + " from " + aDocument.getTeam()+" with "+ winPercentage + " win percentage\n";
        }
        return x;
    }

    public String playerStringListByYear(){
        String x = "";
        int age;
        List<Document> listByYear = listByYear();
        for (Document aDocument : listByYear) {
            age = 2022 - aDocument.getBirthYear();
            x = x + aDocument.getName() + " from " + aDocument.getTeam()+" is now " + age + " years old\n";
        }
        return x;
    }
}
