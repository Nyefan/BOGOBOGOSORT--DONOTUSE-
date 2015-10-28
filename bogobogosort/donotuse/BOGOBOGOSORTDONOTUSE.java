/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bogobogosort.donotuse;

import java.util.Random;



/**
 *
 * @author Nyefan
 */
public class BOGOBOGOSORTDONOTUSE {

    public static Random myRandom = new Random();
    public static void main(String[] args) {
        int[] myArray = {4, 6, 1, -3, 12, 5};
        int[] sortedArray = BOGOSORT(myArray);
        arrayPrint(sortedArray);
    }
    
    public static int[] BOGOSORT(int[] theArray) {
        int trials = 0;
        arrayPrint(theArray);
        
        int[] arrayCopy = theArray.clone();
        arrayPrint(arrayCopy);
        boolean sorted = arraySorted(theArray);
        while(!sorted) {
            arrayCopy = theArray.clone();
            arrayPrint(arrayCopy);
            sorted = BOGOBOGOSORTHELPER(arrayCopy, 1);
            ++trials;
        }
        System.out.println("Trials: " + trials);
        return arrayCopy;
        
    }
    
    public static boolean BOGOBOGOSORTHELPER(int[] theArray, int numSorted) {
               
        int firstIndex = myRandom.nextInt(theArray.length);
        int secondIndex = myRandom.nextInt(theArray.length);
        
        int temp = theArray[firstIndex];
        theArray[firstIndex] = theArray[secondIndex];
        theArray[secondIndex] = temp;
        
        int[] arrayToCheck = new int[numSorted+1];
        System.arraycopy(theArray, 0, arrayToCheck, 0, numSorted+1);
        
        System.out.print("bogo: " + numSorted + "s - ");
        arrayPrint(theArray);
        
        if(arraySorted(theArray)) {
            return true;
        } else if (arraySorted(arrayToCheck)) {
            return BOGOBOGOSORTHELPER(theArray, numSorted+1);
        } else {
            return false;
        }
    }
    
    public static boolean arraySorted(int[] arrayToCheck) {
        boolean sorted = true;
        for (int i = 1; i < arrayToCheck.length; i++) {
            if(arrayToCheck[i-1] > arrayToCheck[i]) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }
    
    public static void arrayPrint(int[] arrayToPrint) {
        for(int i = 0; i < arrayToPrint.length; i++) {
            System.out.print(arrayToPrint[i]+ " ");
        } System.out.print('\n');
    }
}
