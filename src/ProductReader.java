import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class ProductReader {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser(new File("src"));  // Start JFileChooser in the src directory
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            System.out.println("Selected file: " + file.getAbsolutePath());

            try (Scanner scanner = new Scanner(file)) {

                System.out.println(String.format("%-10s %-20s %-30s %-10s", "ID", "Name", "Description", "Cost"));
                System.out.println("===================================================================================");

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] information = line.split(",");  // Split the line by commas

                    if (information.length == 4) {
                        System.out.println(String.format("%-10s %-20s %-30s %-10.2f",
                                information[0], information[1], information[2], Double.parseDouble(information[3])));
                    } else {
                        System.out.println("Invalid line format: " + line);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please check the file path and try again.");
            }
        } else {
            System.out.println("File selection canceled.");
        }
    }
}

