import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
public class Read {

   
    FileReader fr = new FileReader("cards_desc.txt");

    
    BufferedReader br = new BufferedReader(fr);

  
    String line1;

   
    while((line1 = br.readLine()) != null) {
     
        System.out.println(line1);
    }

    // Close the BufferedReader object
    br.close();

    // Create a File object with the file name
    File f = new File("cards_desc.txt");

    // Create a Scanner object with the File object
    Scanner sc = new Scanner(f);

    // Declare another variable for storing each line
    String line2;

    // Read each line until the end of file
    while(sc.hasNextLine()) {
        // Do something with each line
        line2 = sc.nextLine();
        System.out.println(line2);
    }

   // Close the Scanner object
   sc.close();

}