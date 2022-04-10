package Main;

import java.util.*;

public class ManagerDocument {
    List<Document> documents;
    public ManagerDocument managerDocument;

    public static String team;
    public static String name;
    public static String nationality;
    public static Integer wins;
    public static Integer birthYear;
    public static Integer fastestLaps;
    public static Integer races;

    public void addData() {
        Scanner scannerContinue = new Scanner(System.in);
        List<Document> lstDocuments = new ArrayList<Document>();
        int x;
        do {
            Scanner scanner = new Scanner(System.in);
            do {
                try {
                    System.out.print("Enter the driver team: ");
                    team = scanner.nextLine();
                    if (Character.isDigit(team.charAt(0))) {
                        team = "";
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Invalid name");
                }
            } while (Objects.equals(team, ""));

            do {
                try {
                    System.out.print("Enter the driver name: ");
                    name = scanner.nextLine();
                    if (Character.isDigit(name.charAt(0))) {
                        name = "";
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Invalid name");
                }
            } while (Objects.equals(name, ""));


            do {
                try {
                    System.out.print("Enter the driver nationality: ");
                    nationality = scanner.nextLine();
                    if (Character.isDigit(nationality.charAt(0))) {
                        nationality = "";
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Invalid name");
                }
            } while (Objects.equals(nationality, ""));

            boolean validInput = false;
            do {
                System.out.print("Enter the driver's year of birth: ");
                if (scanner.hasNextInt()) {
                    birthYear = scanner.nextInt();
                    validInput = true;
                } else if (birthYear == null || birthYear <= 0) {
                    System.out.println("You have entered incorrect input! Please enter a whole number only");
                } else {
                    System.out.println("You have entered incorrect input! Please enter a whole number only");
                }
                scanner.nextLine();
            } while (!validInput || Integer.toString(birthYear).equals("") || birthYear <= 0);

            boolean validInput1 = false;
            do {
                System.out.print("Enter number of wins of driver: ");
                if (scanner.hasNextInt()) {
                    wins = scanner.nextInt();
                    validInput1 = true;
                } else if (wins == null || wins <= 0) {
                    System.out.println("You have entered incorrect input! Please enter a whole, positive number only");
                } else {
                    System.out.println("You have entered incorrect input! Please enter a whole number only");
                }
                scanner.nextLine();
            } while (!validInput1 || Integer.toString(wins).equals("") || wins <= 0);

            boolean validInput2 = false;
            do {
                System.out.print("Enter number of fastest laps: ");
                if (scanner.hasNextInt()) {
                    fastestLaps = scanner.nextInt();
                    validInput2 = true;
                } else if (fastestLaps == null || fastestLaps <= 0) {
                    System.out.println("You have entered incorrect input! Please enter a whole number only");
                } else {
                    System.out.println("You have entered incorrect input! Please enter a whole number only");
                }
                scanner.nextLine();
            } while (!validInput2 || Integer.toString(fastestLaps).equals("") || fastestLaps <= 0);

            boolean validInput3 = false;
            do {
                System.out.print("Enter the driver's number of races: ");
                if (scanner.hasNextInt()) {
                    races = scanner.nextInt();
                    validInput3 = true;
                } else if (races == null || races <= 0) {
                    System.out.println("You have entered incorrect input! Please enter a whole number only");
                } else {
                    System.out.println("You have entered incorrect input! Please enter a whole number only");
                }
                scanner.nextLine();
            } while (!validInput3 || Integer.toString(races).equals("") || races <= 0);

            Document players = new Players(team, name, wins, fastestLaps, races, birthYear, nationality);
            lstDocuments.add(players);
            System.out.println(players.toString());
            scanner.nextLine();
            System.out.println("""
                    Would you like to add more players?
                    1--YES
                    2--NO
                    """);
            x = scannerContinue.nextInt();
        } while (x == 1);
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

    public void showInfor() {
        this.documents.forEach(documents -> System.out.println(documents.toString()));
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

    public void searchByBook() {
        this.documents.stream().filter(doc -> doc instanceof Players).forEach(doc -> System.out.println(doc.toString()));
    }

    public void top5Wins() {
        List<Document> top5Wins = new ArrayList<>();
        Collections.sort(documents, new DriverWinIndexComparator());
        top5Wins = documents;
        if (top5Wins.size() < 5){
            System.out.println(top5Wins);
        } else{
            for(int i = 0; i < 5; i++) {
                System.out.println(top5Wins.get(i));
            }
        }
    }

    public void top5Fastest_Lap() {
        List<Document> top5FastestLap = new ArrayList<>();
        Collections.sort(documents, new DriverFastestLapComparator());
        top5FastestLap = documents;
        if (top5FastestLap.size() < 5){
            System.out.println(top5FastestLap);
        } else{
            for(int i = 0; i < 5; i++) {
                System.out.println(top5FastestLap.get(i));
            }
        }
    }

    public void bestDriver() {

    }

    public void listByYear() {
        List<Document> listByYear = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Document player = getPlayerByName(name);
        System.out.println("Enter a year to print driver born after ");
        int yearInput = scanner.nextInt();
        Collections.sort(documents, new DriverBirthYearComparator());
        listByYear = documents;
        for(int i = 0; i < listByYear.size(); i++) {
            if (player.getBirthYear() > yearInput) {
                System.out.println(listByYear.get(i));
            }
        }
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
        //Initialize the string
        String string = "";
        //Loops to add Wall to first line of the string
        Document player = getPlayerByName(name);
        for(int i = 0; i < documents.size(); i++) {
            string = string + documents.get(i) + "\t";
        }
        string = string +'\n';
        return string;
    }
}
