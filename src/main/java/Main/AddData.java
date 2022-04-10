package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AddData {
    // GLOBAL VARIABLES TO STORE THE ENTERED DATA OF THE DRIVER
    public static String team;
    public static String name;
    public static String nationality;
    public static Integer wins;
    public static Integer birthYear;
    public static Integer fastestLaps;
    public static Integer races;

    //    ManagerDocument managerDocument = new ManagerDocument();
    public static List<Document> addData() {
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
        return lstDocuments;
    }

    public static void removeData(ManagerDocument managerDocument){
        Scanner scanner =  new Scanner(System.in);
        System.out.print("Enter id to remove: ");
        String id = scanner.nextLine();
        System.out.println(managerDocument.deleteDocument(id) ? "Success" : "Fail");
    }

    public static int addFastestLap(ManagerDocument managerDocument) {
        Scanner scanner =  new Scanner(System.in);
        System.out.print("Enter name to remove: ");
        String name = scanner.nextLine();
        Document player = managerDocument.getPlayerByName(name);
        int currentNoOfRaces = player.getRaces();
        if(player.getName() == null) {
//            return null;
        } else {
            currentNoOfRaces = currentNoOfRaces + 1;
        }
        return currentNoOfRaces;
    }

//    do {
//        try {
//            System.out.print("Enter the driver nationality: ");
//            nationality = scanner.nextLine();
//            if (Character.isDigit(nationality.charAt(0))) {
//                nationality = "";
//            }
//        } catch (StringIndexOutOfBoundsException e) {
//            System.out.println("Invalid name");
//        }
//    } while (Objects.equals(nationality, ""));

    public static void addNumberOfRaces(ManagerDocument managerDocument) {
        Scanner scanner =  new Scanner(System.in);
//        System.out.print("Enter name to remove: ");
//        String name = scanner.nextLine();
        do {
            try {
                System.out.print("Enter name to remove: ");
                String name = scanner.nextLine();
                if (Character.isDigit(name.charAt(0))) {
                    name = "";
                    Document player = managerDocument.getPlayerByName(name);
                    int currentNoOfRaces = player.getRaces();
                    return;
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Invalid name");
            }
        } while (Objects.equals(name, ""));
    }
}
