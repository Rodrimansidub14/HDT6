import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
public class Read {

    public static void main(String[] args) throws Exception {
        
        FileReader fr = new FileReader("cards_desc.txt");
        BufferedReader br = new BufferedReader(fr);
        
        String line1;
        while((line1 = br.readLine()) != null) {
            System.out.println(line1);
        }
        br.close();

        File f = new File("cards_desc.txt");
        Scanner sc = new Scanner(f);
        
        String line2;
        while(sc.hasNextLine()) {
            line2 = sc.nextLine();
            System.out.println(line2);
        }
        sc.close();
    }
}