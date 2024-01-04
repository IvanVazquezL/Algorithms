package QuickUnionUF;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        QuickUnionUF qu = new QuickUnionUF(10);
        qu.union(4,3);
        qu.union(3,8);
        qu.union(6,5);
        qu.union(9,4);
        qu.union(2,1);
        qu.connected(8, 9);
        qu.connected(5, 4);
        qu.union(5,0);
        qu.union(7,2);
        qu.union(6,1);
        qu.union(7,3);
        print();
    }

    public static void print() {
        // Specify the file path and name
        String filePath = "example.txt";

        try {
            // Create a Path object from the file path
            Path path = Paths.get(filePath);

            // Check if the file already exists
            if (!Files.exists(path)) {
                // Create the file
                Files.createFile(path);

                // Write content to the file (optional)
                String content = "Hello, this is a text file!";
                Files.write(path, content.getBytes());

                System.out.println("Text file created successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void RedirectSystemOut() {
        try {
            // Save the current System.out
            PrintStream originalOut = System.out;

            // Create a FileOutputStream to write to a file
            FileOutputStream fileOut = new FileOutputStream("output.txt");

            // Create a PrintStream that writes to the FileOutputStream
            PrintStream printStream = new PrintStream(fileOut);

            // Set System.out to the new PrintStream
            System.setOut(printStream);

            // Now anything printed to System.out will be written to the file
            System.out.println("This will be written to the file.");

            // Restore the original System.out
            System.setOut(originalOut);

            // This will be printed to the console, not the file
            System.out.println("This will be printed to the console.");

            // Close the file output stream
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
