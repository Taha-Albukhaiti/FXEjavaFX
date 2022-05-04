package com.example.fxejavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * A class to illustrate event handling with textField
 * @author agathe merceron
 *
 */


public class Hotel010 extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            GridPane root = new GridPane();
            root.setHgap(10);
            root.setVgap(10);
            root.setPadding(new Insets(25, 25, 25, 25));

            Text hotelIbisMitte =
                    new Text("ibis Styles Hotel Berlin Mitte\n"
                            + "Brunnenstrasse 1-2\n" +"10119 Berlin");
            root.add(hotelIbisMitte, 1, 0);

            Image image = new Image (getClass().getResource(
                    "/Unknown.jpeg").toString());
            ImageView imageview = new ImageView(image);
            root.add(imageview, 0, 0);



            Label labelrating = new Label("current rating:");
            root.add(labelrating, 0, 1);
            Label currentrating = new Label("3.75");
            root.add(currentrating, 1, 1);

            Button button = new Button("Enter your rating");

            root.add(button, 0, 3);

            Label l = new Label("Your rating:");
            l.setVisible(false);
            root.add(l, 0, 5);

            TextField myrating = new TextField();
            myrating.setVisible(false);
            root.add(myrating, 1, 5);
            // The Parameter of setOnAction inherited from ButtonBase
            // is of Type EventHandler<T extends Event>, a functional
            // Interface.
            // The unique instance method handle is implemented
            // with a lambda expression.
            // Preferred way with an extra method as here enterRating
            // when the body of the method has several lines
            button.setOnAction(e -> enterRating(l, myrating));
            // Other possible way because the body of the method
            // is still small: only 2 lines.
//          button.setOnAction(e -> {l.setVisible(true);
//              myrating.setVisible(true);
//          });

            // The Parameter of setOnAction of the class TextField
            // is of Type EventHandler<T extends Event>, a functional
            // Interface.
            // The unique instance method handle is implemented
            // with a lambda expression.
            // As the body of the method has 2 lines only
            // it is programmed directly in the lambda expression

            myrating.setOnAction( e -> {
                String s = myrating.getText();
                currentrating.setText(s);
            });

            Scene scene = new Scene(root,400,400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void enterRating(Label l, TextField t){
        l.setVisible(true);
        t.setVisible(true);

    }

    public static void main(String[] args) {
        launch(args);
    }
}