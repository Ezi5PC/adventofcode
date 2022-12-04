package fourthday;


import java.io.BufferedReader;
import java.io.FileReader;

public class Ranges {
    int rangeBegin;
    int rangeEnd;

    Ranges(int begin, int end){
        this.rangeBegin = begin;
        this.rangeEnd = end;
    }

    public static void main(String[] args) {
        try(FileReader fr = new FileReader("fourthday.txt");
            BufferedReader br = new BufferedReader(fr);){
            String line = "";
            int result = 0;
            while((line = br.readLine()) != null){
                String[] pair = line.split(",");
                Ranges firstRange = new Ranges(Integer.parseInt(pair[0].split("-")[0]),
                        Integer.parseInt(pair[0].split("-")[1]));
                Ranges secondRange = new Ranges(Integer.parseInt(pair[1].split("-")[0]),
                        Integer.parseInt(pair[1].split("-")[1]));
                if((firstRange.rangeBegin >= secondRange.rangeBegin && firstRange.rangeEnd <= secondRange.rangeEnd)
                    || (firstRange.rangeBegin <= secondRange.rangeBegin && firstRange.rangeEnd >= secondRange.rangeEnd)
                    || (firstRange.rangeBegin < secondRange.rangeBegin && firstRange.rangeEnd < secondRange.rangeEnd && firstRange.rangeEnd >= secondRange.rangeBegin)
                    || (firstRange.rangeBegin > secondRange.rangeBegin && firstRange.rangeBegin <= secondRange.rangeEnd && firstRange.rangeEnd > secondRange.rangeEnd)
                    || (secondRange.rangeBegin < firstRange.rangeBegin && secondRange.rangeEnd < firstRange.rangeEnd && secondRange.rangeEnd >= firstRange.rangeBegin)
                    || (secondRange.rangeBegin > firstRange.rangeBegin && secondRange.rangeBegin <= secondRange.rangeEnd && secondRange.rangeEnd > secondRange.rangeEnd)){
                    result++;
                }
            }
            System.out.println(result);
        }catch(Exception ex){
            ex.getMessage();
        }
    }
}
