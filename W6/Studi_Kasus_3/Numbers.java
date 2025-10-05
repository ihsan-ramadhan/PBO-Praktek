//*******************************************************
// Numbers.java
//
// Demonstrates sorting on an array of integers.
//*******************************************************
import java.util.Scanner;

public class Numbers
{
    //------------------------------------------------------------
    // Reads in an array of integers, sorts them,
    // then prints them in sorted order.
    //------------------------------------------------------------
    public static void main(String[] args)
    {
        // ubah int[] menjadi Integer[]
        Integer[] intList;
        int size;

        Scanner scan = new Scanner(System.in);

        System.out.print ("\nHow many integers do you want to sort? ");
        size = scan.nextInt();
        intList = new Integer [size]; //gunakan Integer[]
        
        System.out.println ("\nEnter the numbers...");
        for (int i=0; i < size; i++)
            intList[i] = scan.nextInt(); 
        
        // tugas 4: Ubah ke insertionSort
        Sorting.insertionSort (intList); 

        System.out.println("\nYour numbers in sorted order...");
        for (int i=0; i < size; i++)
            System.out.print(intList [i] + " ");
        System.out.println();
    }
}