package recurssion;

public class LastLocation {
    public static int lastLocation(int[] arr, int x, int idx) {


        int li = lastLocation(arr, x, idx + 1);
        if (li == -1) {
            if(arr[idx] == x){
                return idx;
            }
            else{
                return -1;
            }
        } else {
           return li;
            }
        }
    }

