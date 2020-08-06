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
        for (int i = 0; i < d; i++) {

            aItems = shiftLeft(aItems);
        }

        for(int i =0 ; i<aItems.length; i++){
            System.out.print(aItems[i] + " ");
        }

        scanner.close();
    }

    public static String[] shiftLeft(String[] aItem){
        String temp=aItem[0];
        int len = aItem.length;
        for(int i = 1; i<len;i++){
            aItem[i-1]=aItem[i];
        }
        aItem[len-1]=temp;
        return aItem;
    }
}
