import java.util.HashMap;

class hw2{


public static int funct(int[] arr){
    int[] pref = new int[arr.length];
    int count = 0;
    int longest = 0;
    HashMap T = new HashMap<Integer, Integer>();    
    for(int i = 0; i < arr.length; i++){
        if(i == 0){
            pref[i] = arr[i];
            count++;
            continue;
        }
        else{
            pref[i] = pref[i-1] + arr[i];
        }
        if(pref[i] == 0){
            if(longest < count){
                longest = count;
            }
            count = 1;
        }
        else if(arr[i] == 0 && longest == 0){
            longest = 1;
        }
        else if(T.containsKey(pref[i])){
            if(longest < count){
                longest = count;
            }
            count = 1;
        }
        else{
            count++;
            T.put(pref[i], 0);
        }
    }
    return longest;
    
}

public static void main(String[] args){
    int[] arr = {4, 2, -7, 1, 7, 5, -1, -2, -6, 1, -4, 18};
    System.out.println(funct(arr));
    int[] arr2 = {13, 1, 0, -2};
    System.out.println(funct(arr2));
    int[] arr3 = {13, 1, -2};
    System.out.println(funct(arr3));
    int[] arr4 = {13, 11, -2, 1, 7, -15, -2, 3, -3, 10};
    System.out.println(funct(arr4));

    
}

}
