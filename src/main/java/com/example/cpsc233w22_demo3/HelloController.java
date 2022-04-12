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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
    private Label leftStatus;

    @FXML
    private TextArea mainView;

    @FXML
    private TextField nameToDelete;

    @FXML
    private MenuItem quit;

    @FXML
    private Label rightStatus;

    @FXML
    private SplitMenuButton selectFeatures;

    @FXML
    private Button showFeaturesButton;

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

    /**
     * Add drivers created by the users.
     *
     * @param event
     */
    @FXML
    void addDriverButton(MouseEvent event) {
        if (driverWin >= 0 && driverFastestLap >= 0 && driverRaces >= 0 && driverBirthYear >= 0) {
            Document driver = new Players(driverTeam, driverName, driverWin, driverFastestLap, driverRaces, driverBirthYear, driverNation);
            managerDocument.addPlayers(driver);
            mainView.setText(managerDocument.playerString());
            rightStatus.setText("Driver added!");
            Color color = Color.BLUE;
            rightStatus.setTextFill(color);
        } else {
            leftStatus.setText("Can't add this driver, please check your input!");
            Color color = Color.RED;
            leftStatus.setTextFill(color);
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
    void handleNameToDelete(KeyEvent event) {

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
            //Catch exception and print out statement to left status
        } catch (Exception e){
            leftStatus.setText("No File Inserted!");
            Color color = Color.RED;
            leftStatus.setTextFill(color);
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
        selectFeatures.setText("Best Drivers");
        mainView.setText(managerDocument.playerStringForBestDriver());
    }

    /**
     * Method to delete player by their names then print the result to the mainView
     *
     * @param event
     */
    @FXML
    void deletePlayerButton(MouseEvent event) {
        String name = nameToDelete.getText();
//        mainView.setText(managerDocument.deleteDocument(name) ? "Success" : "Fail");
//        managerDocument.deleteDocument(name);
        rightStatus.setText(managerDocument.deleteDocument(name) ? "Success" : "Fail");
        mainView.setText(managerDocument.playerString());
        Color color = Color.BLUE;
        rightStatus.setTextFill(color);
    }

    /**
     * Method to print out list of drivers based on number of the fastest laps to the mainView
     *
     * @param event
     */
    @FXML
    void driversByFastestLap(ActionEvent event) {
        //Set text of the button to what user selected
        selectFeatures.setText("Drivers By Fastest Lap");
        mainView.setText(managerDocument.playerStringForDriverByFastestLap());
    }

    /**
     * Method to print out list of drivers over certain ages to the mainView
     *
     * @param event
     */
    @FXML
    void driversOverCertainAge(ActionEvent event) {
        //Set text of the button to what user selected
        selectFeatures.setText("Drivers over a certain age");
        mainView.setText(managerDocument.playerStringListByYear());
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
            leftStatus.setText("You haven't entered player's name!");
            Color color = Color.RED;
            leftStatus.setTextFill(color);
        } else if(driverWinUpdate < 0 || driverRacesUpdate < 0 || driverFastestLapUpdate < 0 || driverBirthYearUpdate < 0){
            leftStatus.setText("Can't modified this driver, please check your input!");
            Color color = Color.RED;
            leftStatus.setTextFill(color);
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
        }
        leftStatus.setText("");
        rightStatus.setText("");
//        players.setWins(driverWinUpdate);
//        mainView.setText(managerDocument.playerString());
    }
}