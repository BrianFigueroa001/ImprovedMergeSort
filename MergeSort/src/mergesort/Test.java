package mergesort;

public class Test
{

    public static void main( String[] args )
    {
        int[] arr = {10, 200, 78, 5, 3};

        for ( int i = 0 ; i <= arr.length ; i ++ )
        {
            if ( i == arr.length )
            {
                System.out.print( "\n" );
            } 
            else
            {
                System.out.print( arr[ i ] + " " );
            }
        }

        MergeSort ms = new MergeSort();

        arr = ms.mergeSort( arr );

        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
