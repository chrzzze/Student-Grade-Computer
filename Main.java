import java.io.*;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
       
        File subjectstxt = new File("data//subjects.txt");
        DataManagement.write(subjectstxt.getPath(),  "test test ahhhhhh"); //testing lang toh, the file is DataManagement.java

        String contents = DataManagement.read(subjectstxt.getPath());
        System.out.println(contents);
       
       
       
        // try {
        //     File subjectstxt = new File("data//subjects.txt");
        //     FileReader reader = new FileReader(subjectstxt.getPath());
        //     BufferedReader bufferedReader = new BufferedReader(reader);

        //     String line;
        //     while ((line = bufferedReader.readLine()) != null) {
        //         System.out.println(line);
        //     }
        //     reader.close();
        // } catch (IOException e) {
        //     System.out.println("you did it wrong");
        // }
    }
}