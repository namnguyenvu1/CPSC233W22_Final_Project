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
import java.util.ArrayList;
import java.util.List;

public class HelloController {
//    private List<Document> documents = new ArrayList<>();
    ManagerDocument managerDocument = new ManagerDocument();
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

    @FXML
    void addDriverButton(MouseEvent event) {
        Document driver = new Players(driverTeam, driverName, driverWin, driverFastestLap, driverRaces, driverBirthYear, driverNation);
//        documents.add(driver);
        managerDocument.addPlayers(driver);
        mainView.setText(managerDocument.playerString());
    }

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
        }
        catch (Exception e){
            System.out.println(e);
        }
        return driverBirthYear;
    }

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
        }
        catch (Exception e){
            System.out.println(e);
        }
        return driverFastestLap;
    }

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

    @FXML
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
        }
        catch (Exception e){
            System.out.println(e);
        }
        return driverRaces;
    }

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
        }
        catch (Exception e){
            System.out.println(e);
        }
        return driverWin;
    }

    @FXML
    void handleNameToDelete(KeyEvent event) {

    }

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
        }
        catch (Exception e){
            System.out.println(e);
        }
        return driverBirthYearUpdate;
    }

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
        }
        catch (Exception e){
            System.out.println(e);
        }
        return driverFastestLapUpdate;
    }

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
        }
        catch (Exception e){
            System.out.println(e);
        }
        return driverRacesUpdate;
    }

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
        }
        catch (Exception e){
            System.out.println(e);
        }
        return driverWinUpdate;
    }

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

    @FXML
    void quitProgram(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void saveFile(ActionEvent event) {
        //Use file chooser to set directory to save file
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
        fileChooser.setInitialFileName("statistics.txt");

        File file = fileChooser.showSaveDialog(new Stage());
        //Initialize a string
        List<Document> x = managerDocument.getDocuments();
        String string = "";
        string = managerDocument.getsize() + "\n";
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

    @FXML
    void bestDrivers(ActionEvent event) {
        //Set text of the button to what user selected
        selectFeatures.setText("Best Drivers");
        mainView.setText(managerDocument.playerStringForBestDriver());
    }

    @FXML
    void deletePlayerButton(MouseEvent event) {
        String name = nameToDelete.getText();
//        mainView.setText(managerDocument.deleteDocument(name) ? "Success" : "Fail");
        managerDocument.deleteDocument(name);
        mainView.setText(managerDocument.playerString());
    }

    @FXML
    void driversByFastestLap(ActionEvent event) {
        //Set text of the button to what user selected
        selectFeatures.setText("Drivers By Fastest Lap");
        mainView.setText(managerDocument.playerStringForDriverByFastestLap());
    }

    @FXML
    void driversOverCertainAge(ActionEvent event) {
        //Set text of the button to what user selected
        selectFeatures.setText("Drivers over a certain age");
        mainView.setText(managerDocument.playerStringListByYear());
    }

    @FXML
    void top5Wins(ActionEvent event) {
        //Set text of the button to what user selected
        selectFeatures.setText("Top 5 Wins");
        mainView.setText(managerDocument.playerStringForTop5Wins());
    }

    @FXML
    void updateDriverDataButton(MouseEvent event) {
        Document players = managerDocument.getPlayerByName(driverNameUpdate);
        if (players == null){
            //Handle
        }
        players.setWins(driverWinUpdate);
        mainView.setText(managerDocument.playerString());
    }
}