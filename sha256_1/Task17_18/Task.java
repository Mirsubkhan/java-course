package Task17_18;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task {
	public static void write(String text, String filepath) {
		Path fileName = Path.of(filepath);
		
		try {
			Files.writeString(fileName, text);
			System.out.println("Data's saved");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String read(String filepath) {
		Path fileName = Path.of(filepath);
		
		try {
			String text = Files.readString(fileName);
			System.out.println(text);
			return text;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static Integer getLines(String filepath) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filepath));
			int lines = 0;
			while (reader.readLine() != null) lines++;
			reader.close();
			return lines;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		write("HT!", "input.txt");
		read("input.txt");
		
		System.out.println(getLines("input.txt"));
	}
}
