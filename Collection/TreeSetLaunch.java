import java.util.TreeSet;

public class TreeSetLaunch {
    public static void main(String[] args) {
        TreeSet ta = new TreeSet<>();
        ta.add(100);
        ta.add(25);
        ta.add(200);
        ta.add(500);
        ta.add(100); // duplicate value
        System.out.println(ta);

        // it stores the data in sorted order
        // it does not allow the duplicate values
        // it uses Binary search tree data structure

        System.out.println(ta.ceiling(100)); // 100
        System.out.println(ta.higher(100)); //200

        System.out.println(ta.floor(200)); //200
        System.out.println(ta.lower(200)); //100

        System.out.println(ta.tailSet(300));
        System.out.println(ta.headSet(300));

    }
    
}
