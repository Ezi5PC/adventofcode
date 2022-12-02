package secondday;

import java.io.BufferedReader;
import java.io.FileReader;

public class RockPaperScissors {
    public static void main(String[] args) {
        try(FileReader fileReader = new FileReader("secondday.txt");
            BufferedReader br = new BufferedReader(fileReader);){

            int score = 0;
            String line = "";
            while((line = br.readLine()) != null){
                String[] signs = line.split(" ");
                switch(signs[0]){
                    case "A":
                        switch(signs[1]){
                            case "X":
                                score += 3;
                                break;
                            case "Y":
                                score += 4;
                                break;
                            case "Z":
                                score += 8;
                                break;
                        }
                        break;
                    case "B":
                        switch(signs[1]){
                            case "X":
                                score += 1;
                                break;
                            case "Y":
                                score += 5;
                                break;
                            case "Z":
                                score += 9;
                                break;
                        }
                        break;
                    case "C":
                        switch(signs[1]){
                            case "X":
                                score += 2;
                                break;
                            case "Y":
                                score += 6;
                                break;
                            case "Z":
                                score += 7;
                                break;
                        }
                        break;
                }
                /*switch(signs[0]){
                    case "A":
                        if(!signs[1].equals("Y")){
                            if(signs[1].equals("X")){
                                score += 4;
                            } else{
                              score += 3;
                            }
                        }
                        else{
                            score += 8;
                        }
                        break;
                    case "B":
                        if(!signs[1].equals("Z")){
                            if(signs[1].equals("Y")){
                                score += 5;
                            } else{
                                score += 1;
                            }
                        }
                        else{
                            score += 9;
                        }
                        break;
                    case "C":
                        if(!signs[1].equals("X")){
                            if(signs[1].equals("Z")){
                                score += 6;
                            } else{
                                score += 2;
                            }
                        }
                        else{
                            score += 7;
                        }
                        break;
                }*/
            }
            System.out.println(score);

        }catch(Exception ex){

        }
    }
}
