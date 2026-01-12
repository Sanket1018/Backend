import java.util.Scanner;

public class LaunchingMultithradingNeed {
    public static void main(String[] args) throws InterruptedException {
        Alpha alpha = new Alpha();
        Beta beta = new Beta();
        Gamma gamma = new Gamma();

        alpha.start();
        alpha.join(); /// main thread wait for alpha to finish

        beta.start();
        beta.join();

        gamma.start();  
        gamma.join();

       
       
        
    }
    
}

class Alpha extends Thread{
    public void bankingActivity()
    {
        System.out.println("Banking Applicaion started");
        System.out.println("Enter your account number :");

        Scanner sc = new Scanner(System.in);
        int accountNumber = sc.nextInt();

        System.out.println("Enter the password");
        int password = sc.nextInt();

        System.out.println("Bank activity terminated");
        System.out.println("********************");
    }
    public void run()
    {
        bankingActivity();
    }

}

class Beta extends Thread{
     public void printingStarsActivity()
    {
        System.out.println("Printing stars activity started");
        for(int i=0;i<4;i++)
        {
            System.out.println("**");
        }
        System.out.println("Printing activity terminated");
        System.out.println("******************************");
    }
    public void run()
    {
        printingStarsActivity();
    }
}

class Gamma extends Thread{
    
    public void importantMessageActivity()
    {
        System.out.println("Important message started...");
        System.out.println("Important message is to focus on skills that you make you great");
        System.out.println("Message activity terminated");
        System.out.println("********************************");
    }
    public void run()
    {
        importantMessageActivity();
    }

}
