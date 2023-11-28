/**
 * Aliza Askari
 * CSE017
 * ala326@lehigh.edu
 * 10/13/23
 * HW_5
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/*
 * Modify the mergeSort method to make it generic and accept two parameters: an arraylist of type E
 *  and a comparator of type E named c.  The method should pass the  comparator object c to the method merge. 
 *  The arraylists firstHalf and secondHalf should be created using the method subList described below.
 */
/**
 * This is our generic mergeSort method which accepts two params
 * @author askar
 * @param ArrayList<E> list, Comparator<E> c
 * @return none
 */
public class Utility {
    public static <E> void mergeSort(ArrayList<E> list, Comparator<E> c) {
        if (list.size() > 1) {//merge Sort
            int mid = list.size() / 2;
            ArrayList<E> firstHalf = new ArrayList<>(list.subList(0, mid));
            ArrayList<E> secondHalf = new ArrayList<>(list.subList(mid, list.size()));
            mergeSort(firstHalf, c);
            mergeSort(secondHalf, c);
            merge(list, firstHalf, secondHalf, c);
        }
    	}
    /**
     * This is our generic mergeSort method which accepts three params
     * @param <E>
     * @param list
     * @param firstHalf
     * @param secondHalf
     * @param c
     */
    //TODO make merge  method generic
    //Modify the merge method to make it generic and accept three arraylists 
    //of type E and a comparator object c. The method should use the method compare
    //of the object c to order the objects from the lists l1 and l2.
    public static <E> void merge(ArrayList<E> l1, ArrayList<E> l2, ArrayList<E> list, Comparator<E> c) {
        int index1 = 0;
        int index2 = 0;
        int indexList = 0;

        while (index1 < l1.size() && index2 < l2.size()) {
            if (c.compare(l1.get(index1), l2.get(index2)) <= 0) {
                list.set(indexList++, l1.get(index1++));
            } else {
                list.set(indexList++, l2.get(index2++));
            }
        }

        while (index1 < l1.size()) {
            list.set(indexList++, l1.get(index1++));
        }

        while (index2 < l2.size()) {
            list.set(indexList++, l2.get(index2++));
        }
    }
    /**
     * The method subList is generic and returns an arraylist with the elements from index start to index end-1 from the arraylist l. 
     * This method should be used to create the array lists firstHalf and secondHalf in the modified mergeSort (arraycopy cannot be used 
     * for ArrayList). The method should throw an exception of type ArraysIndexOutOfBounds if start or end are not within the range of the array 
     * list size or if start is greater than end. If start is equal to end, the method returns null.
     */
    /**
     * This is our subList method which will create the array lists firstHalf and secondHalf 
     * in the modified mergeSort
     * @param <E>
     * @param list
     * @param fromIndex
     * @param toIndex
     * @return list.subList(fromIndex, toIndex);
     */
    public static <E> List<E> subList(List<E> list, int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }
    
    /**
     * This is our subList method which will create the array lists firstHalf and secondHalf 
     * in the modified mergeSort
     * @param <E>
     * @param list
     * @param fromIndex
     * @param toIndex
     * @return
     */
    public static <E> ArrayList<E> subList(ArrayList<E> list, int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > list.size() || fromIndex > toIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (fromIndex == toIndex) {
            return null;
        }
        ArrayList<E> subList = new ArrayList<>(toIndex - fromIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(list.get(i));
        }
        return subList;
    }
}
