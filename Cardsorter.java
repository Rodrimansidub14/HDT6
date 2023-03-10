import java.util.Map;
import java.util.Scanner;

public class Cardsorter{
    
    public static void main(String[] args) {
        MapFactory factory = new MapFactory(); 
        Map <String, String> newMap = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al programa");
        
        System.out.println("1.Selecciona tu mapa");
        int choice = scanner.nextInt();
        while (choice ==1)
        switch(choice){
            case 1:
            System.out.println("Que tipo de Map deseas usar?");
           
            System.out.println("1.Hashmap\n2.LinkedHashMap\n3.TreeMap");
            int sel = scanner.nextInt();
            while(sel >=1 && sel <3){
            switch(sel){
                case 1:
                newMap = factory.createHashMap();
                System.out.println("Que deseas hacer?");
                System.out.println("1.Añadir carta\n2.2.Mostrar carta\3.Mostrar nombre y cantidad de cada carta\n4.Mostrar nombre, tipo y cantidad de carta por tipo\n5.Mostrar nombre y tipo de todas las cartas\n5.Mostrar nombre y tipo de todas las cartas\n6.Mostrar nombre y tipo de todas las clases existentes por tipo\n7.Salir");
                int chc = scanner.nextInt();
                
                while(chc >=1 && chc <=7){
                 switch(chc){
                case 1:

                default:
                System.out.println("Opcion incorrecta, intenta de nuevo");
                 }
                }
            
                break;
                case 2:
                    newMap = factory.createTreeMap();;
                    break;
                case 3:
                    newMap = factory.createLinkedHashMap();
    
                default:
                System.out.println("Opcion incorrecta, intenta de nuevo");
            }
       

    
    }

}

    }
}

