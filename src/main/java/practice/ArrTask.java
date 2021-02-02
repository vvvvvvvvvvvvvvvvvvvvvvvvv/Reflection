package practice;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrTask {
   public static char[][] chars;

    public static void main(String[] args) {
        chars = new char[][]{{'a','b','c','d','e','f'},
                {'a','b','c','d','e','f'},
                {'a','b','c','d','e','f'},
                {'a','b','c','d','e','f'},

        };
        printArr(chars);
        for (int i = 0; i < chars.length; i++) {
            if(i == 0 || i == chars.length - 1) continue;
            for (int j = 0; j < chars[i].length; j++) {
                if(j == 0 || j == chars[i].length - 1 ) continue;
                chars[i][j] ='-';
            }
        }
        printArr(chars);

    }

    public static void printArr(char[][] arr){
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("");
        System.out.println("");
    }


}
