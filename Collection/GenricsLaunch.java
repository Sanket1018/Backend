import java.util.ArrayList;

public class GenricsLaunch {
    public static void main(String[] args) {
        ArrayList al = new ArrayList<>();
        al.add(10);
        al.add(20);
        al.add("Sanket");

        System.out.println(al);
        System.out.println("-------------------");

        // At the time of retrieval we will get the object type data

        int num1 = (Integer) al.get(0);
        System.out.println(num1);

        int num2 = (Integer)al.get(1);
        System.out.println(num2);

        // int num3 = (Integer )al.get(2); // ClassCastException
        // System.out.println(num3);

        // we dont know what type of data is stored in the collection
        // we are doing downcasting every time
        // it is a time consuming process and error prone also
        // so it will be better if we specify the type of data to be stored in the collection

        ArrayList<Integer> al2 = new ArrayList<>();
        al2.add(100);
        al2.add(200);
        al2.add(300);
        // al2.add("Sanket"); // compile time error

        for(int i:al2){
            System.out.println(i);
        }
        // Arraylist have default initial capacity of 10
        // vector have default initial capacity of 10
        // but  when the size exceeds than double the current capacity in case of arraylist and in case of vector it increases by 100%

        // Array have the default typesafety
        // We can provide the typesafety to the collection also using generics
    }
    
}
