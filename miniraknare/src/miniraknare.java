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

    //skapar för att kunna använda senare
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

        //tar in alla saker för miniräknarens design
        initField();

        //gör så att man inte kan skriva i textfield
        inputField.setEditable(false);

        //tar in andra deisgn saker och lägger till så att man trycka in knappar i textfield
        displayLayout.getChildren().add(inputField);

        //initierar populatenumpad
        populateNumpad();

        //initierar displaynumpadbuttons
        displayNunmpadButtons();

        //placerar saker i miniräknaren
        mainLayout.setTop(displayLayout);
        mainLayout.setCenter(numpadLayout);
        mainLayout.setBottom(utilContainer);

        //skapar en window med en viss storlek
        Scene scene = new Scene(mainLayout, 200, 275);
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
        for (int rowIndex = 0; rowIndex < 5; rowIndex++) { //hur många horisontella rader som ska finnas
            for (int columnIndex = 0; columnIndex < 4; columnIndex++) {//hur många vertikala rader som ska finnas
                numpadLayout.add(numpad.get(buttonIndex), columnIndex, rowIndex); //lägger till raderna
                buttonIndex++;
                if (buttonIndex == numpad.size())
                    break;
            }
        }
    }

    private void populateNumpad() {

        //en char för vilka knappar som ska finnas
        char[] numpadKeys = new char[]{'1', '2', '3', '+', '4', '5', '6', '-', '7', '8', '9', '*', ',', '0', '=','/',};

        //en loop för att ska knapparna
        for (char key : numpadKeys) {
            String keyText = key + "";
            Button tempButton = new Button(keyText);
            tempButton.setId(keyText);
            tempButton.setOnAction(event -> {
                inputField.textProperty().set(inputField.textProperty().get() + keyText);
                });
         numpad.add(tempButton); //lägger till knapperna i designen

            //storlek på knapparna
            tempButton.setMinWidth(50);
            tempButton.setMinHeight(50);

            };

        //skapar en clear knapp (C)
        clear = new Button("C");
        clear.setOnAction(event -> {inputField.clear();});

        //lägger till knappen och sätter storlek
        numpad.add(clear);
        clear.setMinWidth(50);
        clear.setMinHeight(50);
    }


    private static void calculate(){
            String eq = "";
            String[] arr = eq.split("");

            ArrayList<String> list = new ArrayList<String>();

            String number = "";
            for (int i = 0; 1 < arr.length; i++) {
                if (Numbers(arr[i])) {
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

                if (i == 0) { //tittar vilken plats input är
                    tal1 = Integer.parseInt(list.get(0));
                } else { //en loop för + - * / och =
                    // Om input är en av dessa tecken så änvänds denna funktion så att miniräknaren räknar med tecknet
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
                    i++;
                }
            }
            System.out.println(tal1);
        }
            //Metod som tittar on input är ett nummer eller tecken
            public static Boolean Numbers(String s){
                if("1234567890".contains(s)){
                    return true;
                }
            else{
                    return false;
                }
            }
        }


