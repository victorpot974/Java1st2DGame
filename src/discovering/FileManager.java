package discovering;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class FileManager {
	
	//private FileWriter writer;
	
	public FileManager() {
		//writer = new FileWriter();
	}
	
	public static void createFile(String filename) {
		
		try {
			File file = new File(filename);
			
			if (file.createNewFile()) {
				System.out.println(filename + " has successfully been created.");
			}
			else {
				System.out.println(filename + " already exists!");
			}
		}
		
		catch (IOException e) {
			System.out.println("Error: file couldn't be created");
			e.printStackTrace();
		}
		
	}
	
	
	public static String readFile(String filename) {
		String fileContent = "";
		try {
			File file = new File(filename);
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) {
				fileContent += reader.nextLine();
			}
			reader.close();
		}
		
		catch (IOException e) {
			System.out.println("Error: file couldn't be created");
			e.printStackTrace();
		}
		return fileContent;
	}
	
	
	
	public static void writeFile(String filename, String content) {
		try {
			FileWriter writer = new FileWriter(filename);
			writer.write(content);
			writer.close();
		}
		
		catch (IOException e) {
			System.out.println("Error: couldn't write on file");
			e.printStackTrace();
		}
	}
	
	
	public static void writeFile(String filename, String content, boolean shouldAppend) {
		try {
			FileWriter writer = new FileWriter(filename);
			if (shouldAppend) {
				writer.append(content);
			}
			else {
				writer.write(content);
			}
			writer.close();
		}
		
		catch (IOException e) {
			System.out.println("Error: couldn't write on file");
			e.printStackTrace();
		}
	}
	
}
