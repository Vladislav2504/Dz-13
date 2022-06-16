package Documents;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        System.out.println("Введите название или номер документа.");
        Scanner scanner1 = new Scanner(System.in);
        String n = scanner1.next();


        try (FileReader file = new FileReader(n)) {
            ArrayList<String> numbers = new ArrayList<>();
            Scanner scanner = new Scanner(file);
            FileWriter writer1 = new FileWriter("Report.txt");

            while (scanner.hasNextLine()) {
                String a = scanner.nextLine();

                if (((a.startsWith("docnum")) || (a.startsWith("kontract")))
                        && (a.length() == 15)) {

                    writer1.write(a + " - Номер и название документа валидны. \n");
                    System.out.print(a);
                    System.out.println(" | Adopted");


                } else if ((a.length() < 15)) {

                    writer1.write(a + " - Название документа и его номер меньше 15 символов. \n");
                    System.out.print(a);
                    System.out.println(" | Error");
                } else if ((a.length() > 15)) {

                    writer1.write(a + " - Название документа и его номер больше 15 символов. \n");
                    System.out.print(a);
                    System.out.println(" | Error");

                } else {
                    writer1.write(a + " - Название документа должно начинаться с 'docnum' или 'kontract'. \n");
                    System.out.print(a);
                    System.out.println(" | Error");
                }

                numbers.add(a);

            }
            System.out.println();

            Set<String> set = new LinkedHashSet<>(numbers);
            numbers.clear();
            numbers.addAll(set);

            for (String el : numbers) {
                System.out.println(el);
            }

            writer1.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
