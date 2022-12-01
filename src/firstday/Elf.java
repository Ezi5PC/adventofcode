package firstday;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Elf {
    ArrayList<Integer> calories;
    public Elf(){
        calories = new ArrayList<>();
    }

    public void addCalories(Integer caloriesToAdd){
        calories.add(caloriesToAdd);
    }

    public int getSum(){
        Integer sum = calories.stream().reduce(0, Integer::sum);
        return sum;
    }
}
