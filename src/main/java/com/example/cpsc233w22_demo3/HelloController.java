package com.example.cpsc233w22_demo3;

import Main.Document;
import Main.ManagerDocument;
import Main.Players;
import Main.Reader;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

public class HelloController {
    ManagerDocument managerDocument = new ManagerDocument();

    // FXML Part
    @FXML
    private TextField addBirthYear;

    @FXML
    private Button addDriverButton;

    @FXML
    private TextField addFastestLap;

    @FXML
    private TextField addName;

    @FXML
    private TextField addNation;

    @FXML
    private TextField addRaces;

    @FXML
    private TextField addTeam;

    @FXML
    private TextField addWin;

    @FXML
    private Button deletePlayer;

    @FXML
    private Button findPlayer;

    @FXML
    private Label leftStatus;

    @FXML
    private TextArea mainView;

    @FXML
    private TextField nameToDelete;

    @FXML
    private TextField nameToFind;

    @FXML
    private MenuItem quit;

    @FXML
    private Label rightStatus;

    @FXML
    private SplitMenuButton selectFeatures;

    @FXML
    private TextField updateBirthYear;

    @FXML
    private Button updateDriverDataButton;

    @FXML
    private TextField updateFastestLap;

    @FXML
    private TextField updateName;

    @FXML
    private TextField updateNation;

    @FXML
    private TextField updateRaces;

    @FXML
    private TextField updateTeam;

    @FXML
    private TextField updateWin;

    // Initialize variables to use to check input later
    int driverBirthYear;
    int driverFastestLap;
    String driverName;
    String driverNation;
    int driverRaces;
    String driverTeam;
    int driverWin;
    int driverBirthYearUpdate;
    int driverFastestLapUpdate;
    String driverNameUpdate;
    String driverNationUpdate;
    int driverRacesUpdate;
    String driverTeamUpdate;
    int driverWinUpdate;
    String nameToDeleteOutput;
    String nameToFindOutput;

    /**
     * Add drivers created by the users.
     *
     * @param event
     */
    @FXML
    void addDriverButton(MouseEvent event) {
        if (driverWin >= 0 && driverFastestLap >= 0 && driverRaces >= 0 && driverBirthYear >= 0 && driverName != null
                && !driverName.equals("") && driverTeam!= null && !Objects.equals(driverTeam, "" )
                && driverNation != null && !driverNation.equals("")) {
            Document driver = new Players(driverTeam, driverName, driverWin, driverFastestLap, driverRaces, driverBirthYear, driverNation);
            managerDocument.addPlayers(driver);
            mainView.setText(managerDocument.playerString());
            rightStatus.setText("Driver added!");
            Color color = Color.BLUE;
            rightStatus.setTextFill(color);
            leftStatus.setText("");
        } else {
            leftStatus.setText("Can't add this driver, please check your input!");
            Color color = Color.RED;
            leftStatus.setTextFill(color);
            rightStatus.setText("");
        }
    }

    /**
     * Check the birth year of driver entered by the users.
     *
     * @param event
     * @return the birth year of driver entered by the users after checked
     */
    @FXML
    int handleAddBirthYear(KeyEvent event) {
        //Try to check birth year input of driver
        try{
            driverBirthYear = Integer.parseInt(addBirthYear.getText());
        }
        //Print out warning message
        catch (NumberFormatException e){
            Alert alert0 = new Alert(Alert.AlertType.CONFIRMATION, "Please enter integer!");
            alert0.setHeaderText("Message");
            alert0.show();
            leftStatus.setText("Can't parse birth year from " + addBirthYear.getText());
            Color color = Color.RED;
            leftStatus.setTextFill(color);
            rightStatus.setText("");
            driverBirthYear = -1;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return driverBirthYear;
    }

    /**
     * Check the number of the fastest laps of driver entered by the users.
     *
     * @param event
     * @return the number of the fastest laps of driver entered by the users after checked
     */
    @FXML
    int handleAddFastestLap(KeyEvent event) {
        //Try to check fastest lap input of driver
        try{
            driverFastestLap = Integer.parseInt(addFastestLap.getText());
        }
        //Print out warning message
        catch (NumberFormatException e){
            Alert alert0 = new Alert(Alert.AlertType.CONFIRMATION, "Please enter integer!");
            alert0.setHeaderText("Message");
            alert0.show();
            leftStatus.setText("Can't parse number of fastest laps from " + addFastestLap.getText());
            Color color = Color.RED;
            leftStatus.setTextFill(color);
            rightStatus.setText("");
            driverFastestLap = -1;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return driverFastestLap;
    }

    /**
     * Check the name of driver entered by the users.
     *
     * @param event
     * @return the name of driver entered by the users after checked
     */
    @FXML
    String handleAddName(KeyEvent event) {
        //Try to check name input of driver
        try{
            driverName = addName.getText();
        }
        //Handle exception
        catch (Exception e){
            System.out.println(e);
            rightStatus.setText("");
            leftStatus.setText("");
        }
        return driverName;
    }

    /**
     * Check the nationality of driver entered by the users.
     *
     * @param event
     * @return the nationality of driver entered by the users after checked
     */
    @FXML
    String handleAddNation(KeyEvent event) {
        //Try to check nation input of driver
        try{
            driverNation = addNation.getText();
        }
        //Handle exception
        catch (Exception e){
            System.out.println(e);
            rightStatus.setText("");
            leftStatus.setText("");
        }
        return driverNation;
    }

    /**
     * Check the number of races of driver entered by the users.
     *
     * @param event
     * @return the number of races of driver entered by the users after checked
     */
    @FXML
    //Notice
    int handleAddRaces(KeyEvent event) {
        //Try to check races input of driver
        try{
            driverRaces = Integer.parseInt(addRaces.getText());
        }
        //Print out warning message
        catch (NumberFormatException e){
            Alert alert0 = new Alert(Alert.AlertType.CONFIRMATION, "Please enter integer!");
            alert0.setHeaderText("Message");
            alert0.show();
            leftStatus.setText("Can't parse number of races from " + addRaces.getText());
            Color color = Color.RED;
            leftStatus.setTextFill(color);
            rightStatus.setText("");
            driverRaces = -1;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return driverRaces;
    }

    /**
     * Check the team name of driver entered by the users.
     *
     * @param event
     * @return the team name of driver entered by the users after checked
     */
    @FXML
    String handleAddTeam(KeyEvent event) {
        //Try to check team input of driver
        try{
            driverTeam = addTeam.getText();
        }
        //Handle exception
        catch (Exception e){
            System.out.println(e);
            rightStatus.setText("");
            leftStatus.setText("");
        }
        return driverTeam;
    }

    /**
     * Check the team of driver entered by the users.
     *
     * @param event
     * @return the team of driver entered by the users after checked
     */
    @FXML
    int handleAddWin(KeyEvent event) {
        //Try to check win input of driver
        try{
            driverWin = Integer.parseInt(addWin.getText());
        }
        //Print out warning message
        catch (NumberFormatException e){
            Alert alert0 = new Alert(Alert.AlertType.CONFIRMATION, "Please enter integer!");
            alert0.setHeaderText("Message");
            alert0.show();
            leftStatus.setText("Can't parse number of wins from " + addWin.getText());
            Color color = Color.RED;
            leftStatus.setTextFill(color);
            rightStatus.setText("");
            driverWin = -1;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return driverWin;
    }

    /**
     * Check the name of driver to delete entered by the users.
     *
     * @param event
     * @return the name of driver to delete entered by the users after checked
     */
    @FXML
    String handleNameToDelete(KeyEvent event) {
        //Try to check name to delete input of driver
        try{
            nameToDeleteOutput = nameToDelete.getText();
        }
        //Handle exception
        catch (Exception e){
            System.out.println(e);
            rightStatus.setText("");
            leftStatus.setText("");
        }
        return nameToDeleteOutput;
    }

    @FXML
    String handleNameToFind(KeyEvent event) {
        try{
            nameToFindOutput = nameToFind.getText();
        }
        //Handle exception
        catch (Exception e){
            System.out.println(e);
            rightStatus.setText("");
            leftStatus.setText("");
        }
        return nameToFindOutput;
    }

    /**
     * Check the updated birth year of driver entered by the users.
     *
     * @param event
     * @return the updated birth year of driver entered by the users after checked
     */
    @FXML
    int handleUpdateBirthYear(KeyEvent event) {
        //Try to check birth year update input of driver
        try{
            driverBirthYearUpdate = Integer.parseInt(updateBirthYear.getText());
        }
        //Print out warning message
        catch (NumberFormatException e){
            Alert alert0 = new Alert(Alert.AlertType.CONFIRMATION, "Please enter integer!");
            alert0.setHeaderText("Message");
            alert0.show();
            leftStatus.setText("Can't parse birth year from " + updateBirthYear.getText());
            Color color = Color.RED;
            leftStatus.setTextFill(color);
            rightStatus.setText("");
            driverBirthYearUpdate = -1;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return driverBirthYearUpdate;
    }

    /**
     * Check the updated number of the fastest lap of driver entered by the users.
     *
     * @param event
     * @return the updated number of the fastest lap of driver entered by the users after checked
     */
    @FXML
    int handleUpdateFastestLap(KeyEvent event) {
        //Try to check fastest lap update input of driver
        try{
            driverFastestLapUpdate = Integer.parseInt(updateFastestLap.getText());
        }
        //Print out warning message
        catch (NumberFormatException e){
            Alert alert0 = new Alert(Alert.AlertType.CONFIRMATION, "Please enter integer!");
            alert0.setHeaderText("Message");
            alert0.show();
            leftStatus.setText("Can't parse number of fastest laps from " + updateFastestLap.getText());
            Color color = Color.RED;
            leftStatus.setTextFill(color);
            rightStatus.setText("");
            driverFastestLapUpdate = -1;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return driverFastestLapUpdate;
    }

    /**
     * Check the updated name of driver entered by the users.
     *
     * @param event
     * @return the updated name of driver entered by the users after checked
     */
    @FXML
    String handleUpdateName(KeyEvent event) {
        //Try to check name update input of driver
        try{
            driverNameUpdate = updateName.getText();
        }
        //Handle exception
        catch (Exception e){
            System.out.println(e);
            rightStatus.setText("");
            leftStatus.setText("");
        }
        return driverNameUpdate;
    }

    /**
     * Check the updated nationality of driver entered by the users.
     *
     * @param event
     * @return the updated nationality of driver entered by the users after checked
     */
    @FXML
    String handleUpdateNation(KeyEvent event) {
        //Try to check nation update input of driver
        try{
            driverNationUpdate = updateNation.getText();
        }
        //Handle exception
        catch (Exception e){
            System.out.println(e);
            rightStatus.setText("");
            leftStatus.setText("");
        }
        return driverNationUpdate;
    }

    /**
     * Check the updated number of races of driver entered by the users.
     *
     * @param event
     * @return the updated number of races of driver entered by the users after checked
     */
    @FXML
    int handleUpdateRaces(KeyEvent event) {
        //Try to check races update input of driver
        try{
            driverRacesUpdate = Integer.parseInt(updateRaces.getText());
        }
        //Print out warning message
        catch (NumberFormatException e){
            Alert alert0 = new Alert(Alert.AlertType.CONFIRMATION, "Please enter integer!");
            alert0.setHeaderText("Message");
            alert0.show();
            leftStatus.setText("Can't parse number of races from " + updateRaces.getText());
            Color color = Color.RED;
            leftStatus.setTextFill(color);
            rightStatus.setText("");
            driverRacesUpdate = -1;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return driverRacesUpdate;
    }

    /**
     * Check the updated team name of driver entered by the users.
     *
     * @param event
     * @return the updated team name of driver entered by the users after checked
     */
    @FXML
    String handleUpdateTeam(KeyEvent event) {
        //Try to check team update input of driver
        try{
            driverTeamUpdate = updateTeam.getText();
        }
        //Handle exception
        catch (Exception e){
            System.out.println(e);
            rightStatus.setText("");
            leftStatus.setText("");
        }
        return driverTeamUpdate;
    }

    /**
     * Check the updated number of wins of driver entered by the users.
     *
     * @param event
     * @return the updated number of wins of driver entered by the users after checked
     */
    @FXML
    int handleUpdateWin(KeyEvent event) {
        //Try to check win update input of driver
        try{
            driverWinUpdate = Integer.parseInt(updateWin.getText());
        }
        //Print out warning message
        catch (NumberFormatException e){
            Alert alert0 = new Alert(Alert.AlertType.CONFIRMATION, "Please enter integer!");
            alert0.setHeaderText("Message");
            alert0.show();
            leftStatus.setText("Can't parse number of wins from " + updateWin.getText());
            Color color = Color.RED;
            leftStatus.setTextFill(color);
            rightStatus.setText("");
            driverWinUpdate = -1;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return driverWinUpdate;
    }

    /**
     * Method to print out list of all drivers to the mainView
     *
     * @param event
     */
    @FXML
    void listAllDrivers(ActionEvent event) {
        selectFeatures.setText("List All Drivers");
        mainView.setText(managerDocument.playerString());
        rightStatus.setText("");
        leftStatus.setText("");
    }

    /**
     * Load the file prepared and print that to the mainView
     *
     * @param event
     */
    @FXML
    void loadFile(ActionEvent event) {
        // Try to load a file
        try {
            final FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("."));
            fileChooser.setInitialFileName("world.txt");
            File fileOpen = fileChooser.showOpenDialog(new Stage());
            System.out.println(fileOpen);
            managerDocument = Reader.loadDocument(new File(String.valueOf(fileOpen)));
            mainView.setText(managerDocument.playerString());
            rightStatus.setText("File loaded!");
            Color color = Color.BLUE;
            rightStatus.setTextFill(color);
            leftStatus.setText("");
            //Catch exception and print out statement to left status
        } catch (Exception e){
            leftStatus.setText("No File Inserted!");
            Color color = Color.RED;
            leftStatus.setTextFill(color);
            rightStatus.setText("");
        }
    }

    /**
     * Alert with info about me/program
     */
    @FXML
    void newMethod(ActionEvent event) {
        //Method to print data about us and the program
        Alert alert0 = new Alert(Alert.AlertType.CONFIRMATION, """
                Author: Nam Nguyen Vu & Smitkumar Saraiya
                Email: namnguyen.vu1@ucalgary.ca & smitkumar.saraiya@ucalgary.ca
                Version: v1.0
                This is a Statistics Tracker for Formula 1 drivers
                """);
        alert0.setHeaderText("Message");
        alert0.show();
        alert0.setTitle("About");
    }

    /**
     * Method to quit program
     *
     * @param event
     */
    @FXML
    void quitProgram(ActionEvent event) {
        Platform.exit();
    }

    /**
     * Save the file so that the users could continue in the future
     *
     * @param event
     */
    @FXML
    void saveFile(ActionEvent event) {
        //Use file chooser to set directory to save file
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
        fileChooser.setInitialFileName("statistics.csv");

        File file = fileChooser.showSaveDialog(new Stage());
        //Initialize a string
        List<Document> x = managerDocument.getDocuments();
        String string = "";
        string = managerDocument.getSize() + "\n";
        for(Document i : x){
            Document player = managerDocument.getPlayerByName(i.getName());
            string = string + player.getTeam() +","+ player.getName()+
                    ","+ player.getWins() + ","+player.getFastestLaps() +
                    ","+ player.getRaces() +","+ player.getBirthYear()+","+ player.getNationality() +"\n";
        }
        System.out.println(string);
        Color color = Color.BLUE;
        leftStatus.setTextFill(color);
        leftStatus.setText("File Saved!");
        rightStatus.setText("");
        //Write the string to the file using PrintWriter
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(string);
            printWriter.close();
            //Handle exception
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * Method to print out list of the best drivers based on their win/races percentages to the mainView
     *
     * @param event
     */
    @FXML
    void bestDrivers(ActionEvent event) {
        //Set text of the button to what user selected
        selectFeatures.setText("Drivers' Ranking");
        mainView.setText(managerDocument.playerStringForBestDriver());
        leftStatus.setText("");
        rightStatus.setText("");
    }

    /**
     * Method to delete player by their names then print the result to the mainView
     *
     * @param event
     */
    @FXML
    void deletePlayerButton(MouseEvent event) {
        String name = nameToDelete.getText();
        rightStatus.setText(managerDocument.deleteDocument(name) ? "Success" : "Fail");
        mainView.setText(managerDocument.playerString());
        Color color = Color.BLUE;
        rightStatus.setTextFill(color);
        leftStatus.setText("");
    }



    /**
     * Method to print out list of drivers based on number of the fastest laps to the mainView
     *
     * @param event
     */
    @FXML
    void driversByFastestLap(ActionEvent event) {
        //Set text of the button to what user selected
        selectFeatures.setText("Top 5 Fastest Lap");
        mainView.setText(managerDocument.playerStringForDriverByFastestLap());
        leftStatus.setText("");
        rightStatus.setText("");
    }

    @FXML
    void findPlayerButton(MouseEvent event) {
        String name = nameToFindOutput;
        if (managerDocument.getPlayerByName(name) != null) {
            Document players = managerDocument.getPlayerByName(name);
            mainView.setText("Name: " + players.getName() + ",\t Team: " + players.getTeam() + ",\t Nationality: "
                    + players.getNationality() + ",\t No of Wins: " + players.getWins() + ",\t No of Races: " + players.getRaces() + ",\t No of Fastest Laps: "
                    + players.getFastestLaps() + ",\t Birth Year: " + players.getBirthYear() + "\n");
            Color color = Color.BLUE;
            rightStatus.setTextFill(color);
            rightStatus.setText("Player found!");
            leftStatus.setText("");
        } else{
            rightStatus.setText("Can't find this driver, please check your input!");
            mainView.setText("Driver " + name + " doesn't exist!");
            Color color = Color.RED;
            rightStatus.setTextFill(color);
            leftStatus.setText("");
        }
    }

    /**
     * Method to print out list of 5 oldest drivers to the mainView
     *
     * @param event
     */
    @FXML
    void fiveOldestDrivers(ActionEvent event) {
        //Set text of the button to what user selected
        selectFeatures.setText("5 Oldest Drivers");
        mainView.setText(managerDocument.playerStringListByYear());
        leftStatus.setText("");
        rightStatus.setText("");
    }

    /**
     * Method to print out list of 5 youngest drivers to the mainView
     *
     * @param event
     */
    @FXML
    void fiveYoungestDrivers(ActionEvent event) {
        //Set text of the button to what user selected
        selectFeatures.setText("5 Youngest Drivers");
        mainView.setText(managerDocument.playerStringListByYearReverse());
        leftStatus.setText("");
        rightStatus.setText("");
    }

    /**
     * Method to print out list of top 5 drivers based on number of the wins to the mainView
     *
     * @param event
     */
    @FXML
    void top5Wins(ActionEvent event) {
        //Set text of the button to what user selected
        selectFeatures.setText("Top 5 Wins");
        mainView.setText(managerDocument.playerStringForTop5Wins());
        leftStatus.setText("");
        rightStatus.setText("");
    }

    /**
     * Button to update driver's data
     *
     * @param event
     */
    @FXML
    void updateDriverDataButton(MouseEvent event) {
        Document players = managerDocument.getPlayerByName(driverNameUpdate);
        if (players == null){
            mainView.setText("Player " + driverNameUpdate + " doesn't exist");
            leftStatus.setText("Please check player's name!");
            Color color = Color.RED;
            leftStatus.setTextFill(color);
        } else if(driverWinUpdate < 0 || driverRacesUpdate < 0 || driverFastestLapUpdate < 0 || driverBirthYearUpdate < 0){
            leftStatus.setText("Can't modified this driver, please check your input!");
            Color color = Color.RED;
            leftStatus.setTextFill(color);
            rightStatus.setText("");
        }
        else {
            if (driverTeamUpdate != null){
                players.setTeam(driverTeamUpdate);
            } if (driverNationUpdate != null){
                players.setNationality(driverNationUpdate);
            } if (driverNameUpdate != null){
                players.setName(driverNameUpdate);
            } if (!Objects.equals(updateWin.getText(), "")){
                players.setWins(driverWinUpdate);
            } if (!Objects.equals(updateRaces.getText(), "")){
                players.setRaces(driverRacesUpdate);
            } if (!Objects.equals(updateFastestLap.getText(), "")){
                players.setFastestLaps(driverFastestLapUpdate);
            } if (!Objects.equals(updateBirthYear.getText(), "")){
                players.setBirthYear(driverBirthYearUpdate);
            }
            mainView.setText(managerDocument.playerString());
            rightStatus.setText("Driver's data updated!");
            Color color = Color.BLUE;
            rightStatus.setTextFill(color);
            leftStatus.setText("");
        }
    }
}