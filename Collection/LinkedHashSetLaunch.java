import java.util.LinkedHashSet;

public class LinkedHashSetLaunch {
    public static void main(String[] args) {
        LinkedHashSet lhs = new LinkedHashSet<>();
        lhs.add(100);
        lhs.add(25);
        lhs.add(200);
        lhs.add(500);
        lhs.add(100); // duplicate value not allowed
        System.out.println(lhs);

    }
    
}