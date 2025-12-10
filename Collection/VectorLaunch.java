import java.util.Vector;



public class VectorLaunch {

    public static void main(String[] args) {
        Vector v = new Vector<>();
        v.add(10);
        v.add(20);
        v.add(30);
        v.addElement(40);
        System.out.println(v);

        java.util.Iterator vl = v.iterator();
        while(vl.hasNext()){
            System.out.println(vl.next());
        }
        
    }


    
    
}
