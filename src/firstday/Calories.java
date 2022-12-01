package firstday;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Calories {
    public static void main(String[] args) {

        ArrayList<Elf> elves = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("firstday.txt"));
            String line = "";
            Elf elf = new Elf();
            while (scanner.hasNext()) {
                line = scanner.nextLine();

                if (!line.trim().isEmpty()) {
                    elf.addCalories(Integer.parseInt(line));
                    System.out.println(line);
                }
                else {
                    elves.add(elf);
                    elf = new Elf();
                }
            }
            Integer result = 0;
            Integer resultIndexFirst = 0;
            for (int i = 0; i < elves.size(); i++) {
                if (elves.get(i).getSum() > result) {
                    result = elves.get(i).getSum();
                    resultIndexFirst = i;
                }
            }
            System.out.println("Biggest amount of calories: " + result + "\nAt elf: " + (resultIndexFirst + 1));

            Integer topThreeSum = result;
            result = 0;
            Integer resultIndexSecond = 0;
            for (int i = 0; i < elves.size(); i++) {
                if (elves.get(i).getSum() > result && i != resultIndexFirst) {
                    result = elves.get(i).getSum();
                    resultIndexSecond = i;
                }
            }

            System.out.println("2nd biggest amount of calories: " + result + "\nAt elf: " + (resultIndexSecond + 1));

            topThreeSum += result;
            result = 0;
            Integer resultIndexThird = 0;
            for (int i = 0; i < elves.size(); i++) {
                if (elves.get(i).getSum() > result && i != resultIndexFirst && i != resultIndexSecond) {
                    result = elves.get(i).getSum();
                }
            }

            System.out.println("2nd biggest amount of calories: " + result + "\nAt elf: " + (resultIndexThird + 1));

            topThreeSum += result;
            System.out.println("Top 3 carrying the most calories, they're carrying together " + topThreeSum + " calories.");

        } catch (Exception ex) {
            System.out.println("Exception van");
        }
    }
}
