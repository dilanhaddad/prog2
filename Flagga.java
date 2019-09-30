import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
//import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Flagga extends Application{

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Drawing a Rectangle
        Rectangle flag_1 = new Rectangle(0, 0, 800, 150);

        //Setting the properties of the rectangle

        flag_1.setFill(Color.RED);


        //Creating a Group object
        Group root = new Group(flag_1);

        //Creating a scene object
        Scene scene = new Scene(root, 600, 300);
        //Setting title to the Stage
        primaryStage.setTitle("Drawing a Rectangle");

        primaryStage.setScene(scene);

        primaryStage.show();
    }



}
