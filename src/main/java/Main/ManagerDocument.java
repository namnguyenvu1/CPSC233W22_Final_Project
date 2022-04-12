package Main;

import java.util.*;

public class ManagerDocument{
    List<Document> documents;
    public ManagerDocument managerDocument;

    /**
     * @return list of drivers
     */
    public List<Document> getDocuments(){
        return documents;
    }

    /**
     * Add a driver to the list of drivers
     * @param players : Take a driver object as a parameter that is to be added to the list of drivers
     */
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

    /**
     * @return size of list of drivers
     */
    public int getSize(){
        return documents.size();
    }

    /**
     * Delete a driver from the list of drivers
     * @param id : name of driver to be deleted
     * @return true if delete was successful or false if not
     */
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

    /**
     * Function to find a driver in a list of drivers and return the object otherwise return null
     * @param name : name of driver to be found in te list of drivers
     * @return driver object if found otherwise return null
     */
    public Document getPlayerByName(String name) {
        Document doc = this.documents.stream()
                .filter(document -> document.getName().equals(name))
                .findFirst().orElse(null);
        if (doc == null) {
            return null;
        }
        return doc;
    }

    /**
     * Function to sort the list of drivers by number of wins
     *
     * @return a list of top 5 players by the number of wins
     */
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

    /**
     * Function to sort the list of drivers by number of the fastest laps
     *
     * @return a list of top 5 players by the number of the fastest laps
     */
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

    /**
     * Function to sort the list of drivers by percentage of number of wins / number of races
     *
     * @return a list of top 5 players by percentage of number of wins / number of races
     */
    public List<Document> bestDriver() {
        List<Document> bestDriver = new ArrayList<>();
        List<Document> bestDriverNew = new ArrayList<>();
        Collections.sort(documents, new BestDriverComparator());
        bestDriver = documents;
        for (int i = 0; i < bestDriver.size(); i++){
            bestDriverNew.add(bestDriver.get(i));
        }
        return bestDriverNew;
    }

    /**
     * Function to sort the list of drivers by their birth year from the oldest one
     *
     * @return a list of top 5 players by drivers by their birth year from the oldest one
     */
    public List<Document> listByYear() {
        List<Document> listByYear = new ArrayList<>();
        List<Document> listByYearNew = new ArrayList<>();
        Collections.sort(documents, new DriverBirthYearComparator());
        listByYear = documents;
        if (listByYear.size() < 5){
            listByYearNew = listByYear;
        } else{
            for(int i = 0; i < 5; i++) {
                listByYearNew.add(listByYear.get(i));
            }
        }
        return listByYearNew;
    }

    /**
     * Function to sort the list of drivers by their birth year from the youngest one
     *
     * @return a list of top 5 players by drivers by their birth year from the youngest one
     */
    public List<Document> listByYearReverse() {
        List<Document> listByYearReverse = new ArrayList<>();
        List<Document> listByYearReverseNew = new ArrayList<>();
        Collections.sort(documents, new DriverBirthYearComparator());
        listByYearReverse = documents;
        if (listByYearReverse.size() < 5){
            for(int i = listByYearReverse.size() - 1; i >= 0; i--) {
                listByYearReverseNew.add(listByYearReverse.get(i));
            }
        } else{
            for(int i = listByYearReverse.size() - 1; i > listByYearReverse.size() - 6; i--) {
                listByYearReverseNew.add(listByYearReverse.get(i));
            }
        }
        return listByYearReverseNew;
    }

    /**
     * Function to get a string of the list of drivers
     *
     * @return string of list of drivers
     */
    public String playerString(){
        String x = "List of all drivers: \n \n";
        for (Document aDocument : documents) {
            x = x + "Name: " + aDocument.getName() +",\t Team: "+ aDocument.getTeam()+",\t Nationality: "
                    + aDocument.getNationality()+",\t No of Wins: " + aDocument.getWins() +",\t No of Races: "+ aDocument.getRaces()+",\t No of Fastest Laps: "
                    + aDocument.getFastestLaps()+",\t Birth Year: " + aDocument.getBirthYear() + "\n";
        }
        return x;
    }

    /**
     * Function to get a string of the list sorted by number of wins from highest to lowest
     *
     * @return string of list of size 5 sorted by number of wins
     */
    public String playerStringForTop5Wins(){
        String x = "List of 5 drivers by number of wins: \n \n";
        List<Document> top5Wins = top5Wins();
        for (Document aDocument : top5Wins) {
            x = x + aDocument.getName() + " from " + aDocument.getTeam() +" with " +aDocument.getWins() + " wins\n";
        }
        return x;
    }

    /**
     * Function to get a string of the list sorted by number of the fastest laps
     *
     * @return string of list sorted by number of the fastest laps
     */
    public String playerStringForDriverByFastestLap(){
        String x = "List of 5 drivers by number of the fastest laps: \n \n";
        List<Document> top5FastestLap = top5Fastest_Lap();
        for (Document aDocument : top5FastestLap) {
            x = x + aDocument.getName() + " from " + aDocument.getTeam() +" with "+ aDocument.getFastestLaps() + " fastest laps\n";
        }
        return x;
    }

    /**
     * Function to get a string of the list sorted by ratio that is calculated by percentage of number of wins / number of races
     *
     * @return string of list sorted by ratio
     */
    public String playerStringForBestDriver(){
        String x = "Driver's ranking by their performance: \n \n";
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

    /**
     * Function to get a string of the list sorted by birth year from the oldest one
     *
     * @return string of list sorted by birth year from the oldest one
     */
    public String playerStringListByYear(){
        String x = "List of 5 oldest drivers: \n \n";
        int age;
        List<Document> listByYear = listByYear();
        for (Document aDocument : listByYear) {
            age = 2022 - aDocument.getBirthYear();
            x = x + aDocument.getName() + " from " + aDocument.getTeam()+" is now " + age + " years old\n";
        }
        return x;
    }

    /**
     * Function to get a string of the list sorted by birth year from the youngest one
     *
     * @return string of list sorted by birth year from the youngest one
     */
    public String playerStringListByYearReverse(){
        String x = "List of 5 youngest drivers: \n \n";
        int age;
        List<Document> listByYearReverse = listByYearReverse();
        for (Document aDocument : listByYearReverse) {
            age = 2022 - aDocument.getBirthYear();
            x = x + aDocument.getName() + " from " + aDocument.getTeam()+" is now " + age + " years old\n";
        }
        return x;
    }
}
