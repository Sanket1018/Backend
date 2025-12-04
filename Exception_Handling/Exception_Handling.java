public class Exception_Handling{
    public static void main(String[] args)
    {
        Exception_Handling eh = new Exception_Handling();
        int num = 10;
        int[] arr = new int[2];
        eh.exceptionsOccurs(num,arr);
    }
    
    public void exceptionsOccurs(int num,int arr[])
    {
       
       try{
         num = 10/0;  
         arr[4] = 10;
       }
       catch(ArithmeticException e)
       {
        System.out.println(e);
       }
       catch(IndexOutOfBoundsException r)
       {
        System.out.println(r);
       }

       System.out.println("Code continues.....");

    }

   
    
}