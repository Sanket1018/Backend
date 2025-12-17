import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LaunchStream {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(20);
        list.add(10);
        list.add(50);
        list.add(40);

        // Collections.sort(list);
        // System.out.println(list);
        // It will change the original list
        
        // using stream api

        Stream<Integer> streamData1 = list.stream();
        Stream<Integer>sortedStream = streamData1.sorted();
        sortedStream.forEach((n) -> {System.out.println(n);});


        Stream<Integer> streamData = list.stream();
        // one steam can be used only one time
        Stream<Integer> streamData2 = streamData.map(n-> n*2);
        streamData2.forEach(n -> {System.out.println(n);});

        // OR
        // Chaining the methods
        list.stream()
        .sorted()
        .map(n -> n*2).forEach((n)-> System.out.println(n));


        // copy a list to set using stream

        List<String> newList = new ArrayList<>();
        newList.add("Sanket");
        newList.add("Akash");
        newList.add("Rohan");
        newList.add("Akshay");
        newList.add("Sanket");

        Set<String> unique_set = newList.stream().collect(Collectors.toSet());
        // printing the set
        System.out.println(unique_set);



        
    }
}
