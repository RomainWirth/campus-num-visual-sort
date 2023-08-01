package edu.campusnum.visualsort.sort;

import edu.campusnum.visualsort.model.ObservableArray;
import edu.campusnum.visualsort.model.Order;

/**
 * Created by Web 74 all right reserved
 * User: vincent
 * Date: 27/07/2023
 * Time: 16:32
 */
public class BubbleSort implements SortAlgorithm{
    @Override
    public void sort(ObservableArray array) {
        /**
        int n = array.getLength();
        int passage = 0;
        boolean permut = true;
        while (permut) {
            permut = false;
            for (int i = 0; i < n-1; i++) {
                if (array.compare(i+1, i).equals(Order.Higher)) {
                    array.swap(i, i+1);
                    permut = true;
                }
            }
            passage++;
        }
        //*/
        //**
        int n = array.getLength();
        int i, j;
        for (i = 0; i < n - 1; i++) {
            for (j = 0; j < n - i - 1; j++) {
                if(array.compare(j, j+1).equals(Order.Higher)) {
                    array.swap(j, j+1);
                }
            }
        }
        //*/
    }
}