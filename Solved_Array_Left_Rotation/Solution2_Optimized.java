import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int temp;
        
        aItems = shiftRight(aItems, Math.abs(n-d));
        

        for(int i =0 ; i<aItems.length; i++){
            System.out.print(aItems[i] + " ");
        }

        scanner.close();
    }

    public static String[] shiftRight(String[] aItem, int movement){

        String[] copyAItem = new String[aItem.length];

        for(int i = 0; i<aItem.length;i++){
            copyAItem[(i+movement)%aItem.length]=aItem[i];
        }
        
        return copyAItem;
    }
}
