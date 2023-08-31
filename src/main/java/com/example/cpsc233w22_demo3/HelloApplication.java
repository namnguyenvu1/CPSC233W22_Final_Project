package com.example.cpsc233w22_demo3;

import Main.Document;
import Main.ManagerDocument;
import Main.Reader;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Statistics Tracker for Formula 1 drivers v1.0");
    }

//    public static void main(String[] args) {
//        launch();
//    }

    public int addNumber(int a, int b){
        return a+b;
    }


    public static void main(String[] args) throws FileNotFoundException {
////        if (args.length != 1) {
////            System.err.println("Invalid number of arguments!");
////            System.exit(1);
////        } else {
//            String filename = args[0];
//            File file = new File(filename);
//            if (file.exists() && file.isFile() && file.canRead()){
//                HelloController controller = new HelloController();
//                controller.setManagerDocument(Reader.loadDocument(file));
//                System.out.println(Reader.loadDocument(file).playerString());
////            } else{
////                System.err.println("Cannot access the file to read it!");
////                System.exit(1);
//            }
////        }
        launch();
    }

//    public static void main(String[] args) throws FileNotFoundException {
//        String filename = args[0];
//        File file = new File(filename);
//        if (file.exists() && file.isFile() && file.canRead()){
//            HelloController controller = new HelloController();
//            controller.setManagerDocument(Reader.loadDocument(file));
//        }
//        launch();
//    }
}