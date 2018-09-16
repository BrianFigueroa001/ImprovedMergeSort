package mergesort;

public class MergeSort
{
    /*
    The idea behind my mergesort algorithm is to 
    'divide' the array repeatedly by tracking the indices.
    The array itself is not actually divided. The array function
    is changed during the merge function
    
    l = far left index 
    r = far right index 
    m = middle index
    arr = the original array
    */

    public int[] mergeSort(int[] arr) {
        if (arr.length == 0)
        {
            System.out.println("Array is empty.");
            return arr;
        }

        int l = 0; //first index
        int r = arr.length - 1; //last index
        arr = sort(arr, l, r);
        
        return arr;
    }
   
    /*
    l = far left index 
    r = far right index 
    m = middle index
    arr = the original array
    */
    private int[] sort(int arr[], int l, int r) {
        if (l < r) //Base case
        {
           int m = (l + r)/2;
           arr = sort(arr, l, m); //Sort left half of the array
           arr = sort(arr, m+1, r); //Sort right half of the array
           arr = merge(arr, l, r, m); //Merge left and right half
        }
        
        return arr;
    }

    private int[] merge(int[] arr, int l, int r, int m){
        int[] helperArray = new int[arr.length];
        
        //Inserts elements into the indices from l to r.
        for (int i = l; i <= r; i++){
            helperArray[i] = arr[i];
        }
        
        int leftTracker = l; //Tracks index in the left half.
        int rightTracker = m + 1; //Tracks index in the right half.
        int index = l; //Index to track position in arr.
        
        //Begin merging left half and right half together.
        while (leftTracker <= m && rightTracker <= r) {
            if (helperArray[leftTracker] <= helperArray[rightTracker]){
                arr[index++] = helperArray[leftTracker++];
            }
            else{
                arr[index++] = helperArray[rightTracker++];
            }
        }
        
        //Insert whatever remains from the left half.
        while (leftTracker <= m)
        {
            arr[index++] = helperArray[leftTracker++];
        }
        
        //Insert whatever remains from the right half.
        while (rightTracker <= r)
        {
            arr[index++] = helperArray[rightTracker++];
        }
        
        return arr;
    }
}
