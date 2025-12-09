import java.util.HashSet;

public class HashSetLaunch {
    public static void main(String[] args) {
        HashSet hs = new HashSet<>();
        hs.add(100);
        hs.add(25);
        hs.add(200);
        hs.add(500);

        // it does not allow duplicate values
        // it does not maintain the insertion order
        System.out.println(hs);

    }
    
}
