import java.util.ArrayList;
import java.util.Collections;

public class LaunchingComplex2 {
    public static void main(String[] args) {
        Cricketer1 c1 = new Cricketer1(38, "Rohit", 56);
        Cricketer1 c2 = new Cricketer1(36, "Virat", 52);
        Cricketer1 c3 = new Cricketer1(39, "Dhoni", 34);

        ArrayList<Cricketer1> cricketers = new ArrayList<>();
        cricketers.add(c1);
        cricketers.add(c2);
        cricketers.add(c3);

        Collections.sort(cricketers);
        System.out.println(cricketers);
    }
}

class Cricketer1 implements Comparable<Cricketer1> {
    private int age;
    private String name;
    double average;

    public Cricketer1(int age, String name, double average) {
        this.age = age;
        this.name = name;
        this.average = average;
    }

    @Override
    public String toString() {
        return "Cricketer [age=" + age + ", name=" + name + ", average=" + average + "]";
    }

    @Override
    public int compareTo(Cricketer1 c1) {
        if (this.average > c1.average) {
            return 1;
        } else if (this.average < c1.average) {
            return -1;
        } else {
            return 0;
        }
    }
}


// what is the difference between Comparable and Comparator in Java?// Comparable is an interface used to define the natural ordering of objects. 
// A class that implements Comparable must override the compareTo() method to specify how its instances should be compared to each other.
// Comparator is an interface used to define an external ordering of objects.

// In comparator we have to create a separate class that implements Comparator interface and override the compare() method to define the comparison logic.
// This allows for multiple different ways to compare objects of the same class without modifying the class itself.
// In summary, Comparable is used for natural ordering within the class itself, while Comparator is used for custom ordering outside the class.
// If we didnt access of the class then we can use comparator.