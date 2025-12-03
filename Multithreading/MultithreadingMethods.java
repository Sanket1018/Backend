public class MultithreadingMethods {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1 executing times : " + i);
                Thread.yield();
            }
        });  

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 9; i++) {
                System.out.println("Thread 2 executing times : " + i);
            }
        });  

        t1.start();
        t2.start();
    }
}
