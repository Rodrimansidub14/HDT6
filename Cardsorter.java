import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.TreeMap;
import java.util.ArrayList;;

public class CardSorter {
    public static void main(String[] args) throws Exception {
        MapFactory mapFactory = new MapFactory();
        Map<String, Card> availableCards = mapFactory.createHashMap();
        Map<String, Integer> userCollection = mapFactory.createHashMap();

        // read file and populate availableCards map
        BufferedReader reader = new BufferedReader(new FileReader("cards_desc.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|");
            String name = parts[0].trim();
            String type = parts[1].trim();
            Card card = new Card(name, type, 0);
            availableCards.put(name, card);
        }
        reader.close();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select map implementation:");
            System.out.println("1. HashMap");
            System.out.println("2. TreeMap");
            System.out.println("3. LinkedHashMap");

            int choice = scanner.nextInt();
            Map<String, Integer> map;
            switch (choice) {
                case 1:
                    map = mapFactory.createHashMap();
                    break;
                case 2:
                    map = mapFactory.createTreeMap();
                    break;
                case 3:
                    map = mapFactory.createLinkedHashMap();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            while (true) {
                System.out.println("Select operation:");
                System.out.println("1. Add card to collection");
                System.out.println("2. Show type of a card");
                System.out.println("3. Show collection");
                System.out.println("4. Show collection by type");
                System.out.println("5. Show available cards");
                System.out.println("6. Show available cards by type");
                System.out.println("0. Exit");

                int operation = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (operation) {
                    case 1:
                        System.out.print("Enter card name: ");
                        String cardName = scanner.nextLine();
                        if (!availableCards.containsKey(cardName)) {
                            System.out.println("Card not found.");
                        } else {
                            userCollection.merge(cardName, 1, Integer::sum);
                            System.out.println(cardName + " added to collection.");
                        }
                        break;
                    case 2:
                        System.out.print("Enter card name: ");
                        cardName = scanner.nextLine();
                        if (!availableCards.containsKey(cardName)) {
                            System.out.println("Card not found.");
                        } else {
                            Card card = availableCards.get(cardName);
                            System.out.println(card.getType());
                        }
                        break;
                    case 3:
                        System.out.println("Collection:");
                        for (Map.Entry<String, Integer> entry : userCollection.entrySet()) {
                            String name = entry.getKey();
                            int count = entry.getValue();
                            System.out.println(name + " (" + count + ")");
                        }
                        break;
                    case 4:
                        System.out.println("Collection by type:");
                        Map<String, Integer> collectionByType = mapFactory.createHashMap();
                        for (Map.Entry<String, Integer> entry : userCollection.entrySet()) {
                            String name = entry.getKey();
                            int count = entry.getValue();
                            Card card = availableCards.get(name);
                            String type = card.getType();
                            collectionByType.merge(type, count, Integer::sum);
                        }
                        for (Map.Entry<String, Integer> entry : collectionByType.entrySet()) {
                            String type = entry.getKey();
                            int count = entry.getValue();
                            System.out.println("Type: " + type + " | Count: " + count);
                        }

                        break;
                    case 5:
                        try {
                            File file = new File("cards_desc.txt");
                            Scanner scanner2 = new Scanner(file);

                            while (scanner2.hasNextLine()) {
                                String line2 = scanner2.nextLine();
                                String[] parts = line2.split("\\|");
                                String name = parts[0];
                                String type = parts[1];
                                System.out.println(name + " - " + type);
                            }

                            scanner2.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("Error: File not found.");
                        }

                        break;
                    case 6:
                        try {
                            File file = new File("cards_desc.txt");
                            Scanner scanner3 = new Scanner(file);

                            Map<String, List<String>> cardsByType = new TreeMap<>();

                            while (scanner3.hasNextLine()) {
                                String line3 = scanner3.nextLine();
                                String[] parts = line3.split("\\|"); // use line3 instead of line
                                String name = parts[0];
                                String type = parts[1];
                                List<String> cards = cardsByType.getOrDefault(type, new ArrayList<>());
                                cards.add(name);
                                cardsByType.put(type, cards);
                            }

                            scanner3.close();

                            for (Map.Entry<String, List<String>> entry : cardsByType.entrySet()) {
                                String type = entry.getKey();
                                List<String> cards = entry.getValue();
                                System.out.println(type + ":");
                                for (String card : cards) {
                                    System.out.println("\t" + card);
                                }
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("Error: File not found.");
                        }
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        }
    }
}
