package classwork_1;

import java.io.*;
import java.util.Scanner;

public class Reader1 {

    public static void readFile(String filePath) {
    	try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("File Info:");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } 
    	catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the file path:");

        String filePath = scanner.nextLine();

        readFile(filePath);
        
        scanner.close();
    }
}
