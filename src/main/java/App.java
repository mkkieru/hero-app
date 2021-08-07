import static spark.Spark.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");


        showMessageDialog(null,"This is an alert!!");

    }
}
