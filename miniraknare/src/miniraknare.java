import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.lang.String;
import java.util.ArrayList;

public class miniraknare extends Application {

    TextField inputField;
    ArrayList<Button> numpad;
    Button clear;
    GridPane numpadLayout;
    HBox utilContainer;
    BorderPane mainLayout;
    VBox displayLayout;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Kalkulatorn");

        initField();

        displayLayout.getChildren().add(inputField);

        populateNumpad();
        displayNunmpadButtons();

        mainLayout.setTop(displayLayout);
        mainLayout.setCenter(numpadLayout);
        mainLayout.setBottom(utilContainer);

        Scene scene = new Scene(mainLayout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initField() {
        inputField = new TextField();
        numpad = new ArrayList<Button>();
        numpadLayout = new GridPane();
        utilContainer = new HBox();
        displayLayout = new VBox();
        mainLayout = new BorderPane();
    }

    private void displayNunmpadButtons() {
        int buttonIndex = 0;
        for (int rowIndex = 0; rowIndex < 5; rowIndex++) {
            for (int columnIndex = 0; columnIndex < 4; columnIndex++) {
                numpadLayout.add(numpad.get(buttonIndex), columnIndex, rowIndex);
                buttonIndex++;
                if (buttonIndex == numpad.size())
                    break;
            }
        }
    }

    private void populateNumpad() {
        char[] numpadKeys = new char[]{'1', '2', '3', '+', '4', '5', '6', '-', '7', '8', '9', '*', ',', '0', '=','/'};

        for (char key : numpadKeys) {
            String keyText = key + "";
            Button tempButton = new Button(keyText);
            tempButton.setId(keyText);
            tempButton.setOnAction(event -> {
                inputField.textProperty().set(inputField.textProperty().get() + keyText);
                });
         numpad.add(tempButton);
            tempButton.setMinWidth(40);
            tempButton.setMinHeight(40);

            };

        clear = new Button("C");
        clear.setOnAction(event -> {inputField.clear();});

        numpad.add(clear);
        clear.setMinWidth(40);
        clear.setMinHeight(40);
    }


    private static void calculate(){
            String eq = "10+10-10/10*10";
            String[] arr = eq.split("");

            ArrayList<String> list = new ArrayList<String>();

            String number = "";
            for (int i = 0; 1 < arr.length; i++) {
                if (isNumeric(arr[i])) {
                    number += arr[i];
                } else {
                    if(number.equals("") && arr[i].equals("-")){
                        number = "-" + number;
                    }
                    list.add(number);
                    number = "";
                    list.add(arr[i]);
                }
            }
            list.add(number);

            System.out.println(list);
            int tal1 = 0;
            for (int i = 0; i < list.size(); i++) {

                if (i % 2 == 0) {
                    tal1 = Integer.parseInt(list.get(1));
                } else {
                    if (list.get(i).equals("+")) {
                        tal1 = tal1 + Integer.parseInt(list.get(i + 1));
                    }
                    if (list.get(i).equals("-")) {
                        tal1 = tal1 - Integer.parseInt(list.get(i + 1));
                    }
                    if (list.get(i).equals("*")) {
                        tal1 = tal1 * Integer.parseInt(list.get(i + 1));
                    }
                    if (list.get(i).equals("/")) {
                        tal1 = tal1 / Integer.parseInt(list.get(i + 1));
                    }
                    //if (list.contains("=")){
                      //  String[]
                   // }
                    i++;
                }
            }
            System.out.println(tal1);
        }

            public static Boolean isNumeric (String s){
                if("1234567890".contains(s)){
                    return true;
                }
            else{
                    return false;
                }
            }
        }


