import javax.swing.plaf.synth.SynthStyleFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Book> map = new HashMap<>();

        try {
            readData(map);
            loop(map);
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }

    public static void loop(HashMap<Integer, Book> map) {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("1 - Print Collection (K + V) \n2 - Create and Print List \n3 - Print Ordered List");
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    running = false;
                    break;
                case 1:
                    printData(map);
                    break;
                case 2:
                    var data = getList(map);
                    data.forEach(System.out::println);
                    break;
                case 3:
                    var sortedData = getListB(map);
                    sortedData.forEach(System.out::println);
                    break;
            }
        }
    }

    private static void readData(HashMap<Integer, Book> map) throws IOException {
        File file = new File("in.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");

                var book = new Book(data[1], data[2], Integer.parseInt(data[3].trim()));
                map.put(Integer.parseInt(data[0]), book);
            }
        }
    }

    private static void printData(HashMap<Integer, Book> map) {
        for (var data : map.keySet()) {
            System.out.format("Key: %d, Data: %s\n", data, map.getOrDefault(data, null));
        }
    }

    private static List<Book> getList(HashMap<Integer, Book> map) {
        return map.values().stream().toList();
    }

    private static List<Book> getListB(HashMap<Integer, Book> map) {
        return map.values().stream().sorted((Book a, Book b) -> b.getTitle().compareTo(a.getTitle())).collect(Collectors.toList());
    }
}