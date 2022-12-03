package thirdday;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;

public class WeirdInput {
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[] args) {
        HashMap<Character, Integer> dict = new HashMap<>();
        ArrayList<Character> used;
        for(int i = 0;i < 52; i++){
            Character c = alphabet.charAt(i);
            dict.put(c, i+1);
        }
        for(Character key : dict.keySet()){
            System.out.println(key + " - " + dict.get(key));
        }
        try(FileReader fr = new FileReader("thirdday.txt");
            BufferedReader br = new BufferedReader(fr);
        ){
            String line = "";
            int score = 0;
            int badgeScore = 0;
            while((line = br.readLine()) != null){
                String line1 = line;
                String line2 = br.readLine();
                String line3 = br.readLine();
                String matches12 = "";
                Character c;

                for(int i = 0; i < line1.length();i++){
                    for(int j = 0; j < line2.length(); j++){
                        if(line2.charAt(j) == line1.charAt(i)){
                            matches12 += line2.charAt(j);
                        }
                    }
                }

                boolean found = false;

                for(int i = 0; i < matches12.length(); i++){
                    for(int j = 0; j < line3.length(); j++){
                        if(line3.charAt(j) == matches12.charAt(i)){
                            c = matches12.charAt(i);
                            badgeScore += dict.get(c);
                            found = true;
                            break;
                        }
                    }
                    if(found == true){
                        break;
                    }
                }

                /*String firstpart = line.substring(0, (line.length()) / 2);
                String secondpart = line.substring((line.length()) / 2);
                used = new ArrayList<>();
                for(int i = 0; i < firstpart.length();i++){
                    for(int j = 0; j < secondpart.length(); j++){
                        if(secondpart.charAt(j) == firstpart.charAt(i) && !used.contains(secondpart.charAt(j))){
                            score += dict.get(secondpart.charAt(j));
                            used.add(secondpart.charAt(j));
                        }
                    }
                }*/
            }
            System.out.println(badgeScore);
        }catch(Exception ex){
            ex.getMessage();
        }
    }
}
