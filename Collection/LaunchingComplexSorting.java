import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class LaunchingComplexSorting {
    public static void main(String[] args) {
        Cricketer c1 = new Cricketer(38, "Rohit",56);
        Cricketer c2 = new Cricketer(36,"Virat",52);
        Cricketer c3 = new Cricketer(39,"Dhoni",34);

        ArrayList<Cricketer> cricketers = new ArrayList<>();
        cricketers.add(c1);
        cricketers.add(c2);
        cricketers.add(c3);  
        System.out.println(cricketers);
        
        // Alpha alpha = new Alpha();
        // Collections.sort(cricketers,alpha);
        System.out.println(cricketers);

        //using anonymous class
        // Comparator<Cricketer> c = new Comparator<Cricketer>() {
        //     @Override
        //     public int compare(Cricketer c1,Cricketer c2){
        //         if(c1.average>c2.average){
        //             return 1;
        //         }
        //         else{
        //             return -1;
        //         }
        //     }    
        // };
        // Collections.sort(cricketers,c);
        // System.out.println(cricketers);


        // using lambda expression
        Comparator<Cricketer> c = (Cricketer o1,Cricketer o2) -> {
            if(o1.average>o2.average){
                return 1;
            }
            else{
                return -1;
            }
        };
        Collections.sort(cricketers,c);
        System.out.println(cricketers);
            
    }
    
}

class Cricketer{
        private int age;
        private String name;
        double average;

        public Cricketer(int age,String name,double average)
        {
            this .age = age;
            this.name =name;
            this.average = average;
        }

        public String toString(){
            return age+" "+name+" "+average;
        }
}

//class Alpha implements Comparator<Cricketer>{
    // normal 
    // @Override
    // public int compare(Cricketer o1, Cricketer o2) {
    //     if(o1.average>o2.average)
    //     {
    //         return 1;
    //     }
    //     else{
    //         return -1;
    //     }
    // } 
//}
