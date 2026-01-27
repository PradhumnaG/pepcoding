package recurssion;

public class MaxArray {
    public static   int  maxArray( int [] arr, int idx){
        if(idx == arr.length-1){
            return arr[idx];
        }
        int misa = maxArray(arr, idx+1);
        if(misa > arr[idx]){
            return misa;
        }
        else{

            return arr[idx];
        }
    }

}
