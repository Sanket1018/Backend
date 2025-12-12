import java.util.ArrayList;
import java.util.Collections;
public class SortingArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(500);
        numbers.add(200);
        numbers.add(300);
        numbers.add(100);
        Collections.sort(numbers);
        System.out.println(numbers);

        ArrayList<String> names =new ArrayList<>();
        names.add("Sanket");
        names.add ("Akash");
        names.add("John");
        Collections.sort(names);
        System.out.println(names);    
    } 
}
