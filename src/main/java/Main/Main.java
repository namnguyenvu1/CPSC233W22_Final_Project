package Main;

import Main.Players;
import Main.Document;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Main {
//    public ManagerDocument managerDocument;
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        ManagerDocument managerDocument = new ManagerDocument();
//        HashMap<String, Object[]> strings = new HashMap<>();
        int answer;
        do {
            System.out.print("""
                    *****************************
                    Choose an action to do from the following list:
                    1--Add new driver data
                    2--Remove driver data by name
                    3--Add number of wins to the driver
                    4--Add number of DHL Fastest Lap to the driver
                    5--Add number of races entered to the driver
                    6--Ask for all players to be printed
                    7--Ask for the top 5 drivers by number of wins
                    8--Ask for the list of drivers by number of fastest lap
                    9--Ask for best drivers
                    10--List of players over a certain age
                    *****************************
                    """);
            int input = scanner.nextInt();
            if (input == 1) {
                managerDocument.addData();
            } else if (input ==2 ){
                managerDocument.removeData();
            } else if (input == 3){
                managerDocument.addNumberWin();
            } else if (input == 4){
                managerDocument.addFastestLap();
            } else if (input == 5){
                managerDocument.addNumberOfRaces();
            } else if (input == 6) {
                managerDocument.showInfor();
            }
            else if (input == 7) {
                managerDocument.top5Wins();
            }
            else if (input == 8) {
                managerDocument.top5Fastest_Lap();
            }
            else if (input == 9) {
                managerDocument.bestDriver();
            }
            else if (input == 10){
                managerDocument.listByYear();
            }
            System.out.println("Access menu again?");
            System.out.println("1--Yes");
            System.out.println("2--No");
            answer = scanner.nextInt();
        } while (answer == 1);
    }
}
