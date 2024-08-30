import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {

    public static void main(String[] args) {
        ArrayList<String> personData = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        String fileName = SafeInput.getNonEmptyString(input, "Enter the name of the file to save the information to: ");

        boolean done = false;
        while (!done) {

            String id = SafeInput.getNonEmptyString(input, "Enter the ID: ");
            String firstName = SafeInput.getNonEmptyString(input, "Enter the first name: ");
            String lastName = SafeInput.getNonEmptyString(input, "Enter the last name: ");
            String title = SafeInput.getNonEmptyString(input, "Enter the title, (like Mr., Mrs., Ms., Dr., etc.): ");
            int yearOfBirth = SafeInput.getInt(input, "Enter the year of birth (0 to 2022): ", 0, 2022);

            personData.add(id + "," + firstName + "," + lastName + "," + title + "," + yearOfBirth);

            String cont = SafeInput.getNonEmptyString(input, "Are you finished entering information? (yes/no): ");

            if (cont.equalsIgnoreCase("yes")) {
                done = true;
            }
        }

        saveToFile(personData, fileName);
        System.out.println("Data saved to " + fileName);
    }

    private static void saveToFile(ArrayList<String> personData, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String person : personData) {
                writer.write(person + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file.");
            e.printStackTrace();
        }
    }
}

