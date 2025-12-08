public class Second_smallest_another {
    public static void main(String[] args) {
        int arr[] = {10,20,30,40};

        int temp = 0;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                
                if(arr[i]<arr[j])
                {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                if(i==1)
                {
                    break;
                }  
            }  
        }
        System.out.println("Smallest element is : "+arr[1]);
    }
    
}
