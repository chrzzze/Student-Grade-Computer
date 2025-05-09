import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataManagement {
    static void write (String target, String content) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(target))) { //make a writer to a target filepath string. hopefully????
            writer.write(content); //the actual writing
            System.out.println("Text successfully saved to: " + target); 
        } catch (IOException e) {
            System.err.println("Error saving to file: " + e.getMessage());
        } 
    }

    static String read (String target) {


        String result = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) { //open reader

        String line;
        while ((line = reader.readLine()) != null) { //store each line into variable line
             System.out.println(line); //para lang makita kung ano laman ni line
             result = result + ", " + line; //append each line into result with a comma
             
        }
            
        } catch (IOException e) {
            System.out.println("Can't read."); //u fucked up
        } 
        
        return result;
    }
}
