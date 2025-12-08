public class Second_smallest {
    public static void main(String[] args)
    {
        int arr[] = {10,20,30,40};
        Second_smallest sm = new Second_smallest();
        int min = sm.smallest(arr);
        System.out.println("Min value "+min);

        int second_min = sm.other_array(arr);
        System.out.println("Second min is : "+second_min);
         

    }
    public int smallest(int arr[])
    {
        int min = arr[0];
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[j] < arr[i])
                {
                    min = arr[j];
                }
            }
        }
        return min;
    }
    public int other_array(int arr[])
    {
        int min = smallest(arr);
        int res[] = new int[arr.length-1];
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>min)
            {
                res[i] = arr[i];
            }
        }

        // logic to calulate second max
        int second_min = res[0];
        for(int i=0;i<res.length;i++)
        {
            if(res[i] < min)
            {
                second_min = res[i];
                System.out.println(second_min);
            }
        }
        return second_min;
    }
}
