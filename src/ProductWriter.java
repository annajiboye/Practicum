import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {

    public static void main(String[] args) {
        ArrayList<String> productData = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        boolean done = false;
        while (!done) {
            String id = SafeInput.getNonEmptyString(input, "Enter the Product ID: ");
            String name = SafeInput.getNonEmptyString(input, "Enter the Product Name: ");
            String description = SafeInput.getNonEmptyString(input, "Enter the Product Description: ");
            double cost = SafeInput.getDouble(input, "Enter the Product Cost: ");

            productData.add(id + "," + name + "," + description + "," + cost);

            String cont = SafeInput.getNonEmptyString(input, "Are you done entering products? (yes/no): ");
            if (cont.equalsIgnoreCase("yes")) {
                done = true;
            }
        }

        String fileName = SafeInput.getNonEmptyString(input, "Enter the name of the file to save the product information: ");

        try (FileWriter writer = new FileWriter(fileName)) {
            for (String product : productData) {
                writer.write(product + "\n");
            }
            System.out.println("Product information successfully saved to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file. Please try again.");
            e.printStackTrace();
        }
    }
}
