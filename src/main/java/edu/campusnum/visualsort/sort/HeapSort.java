package edu.campusnum.visualsort.sort;

import edu.campusnum.visualsort.model.ObservableArray;
import edu.campusnum.visualsort.model.Order;

/**
 * Created by Web 74 all right reserved
 * User: vincent
 * Date: 27/07/2023
 * Time: 16:31
 */
public class HeapSort implements SortAlgorithm{
    @Override
    public void sort(ObservableArray array) {
        int n = array.getLength();
        organize(array);
        for (int i = n-1; i > 0; i--) {
            array.swap(0, i);
            goBackDown(array, i, 0);
        }
    }
    public void organize(ObservableArray array) {
        int n = array.getLength();
        for (int i = 0; i < n-1; i++) {
            goBackUp(array, i);
        }
    }
    public void goBackUp(ObservableArray array, int i) {
        if(array.compare(i, i/2).equals(Order.Higher)) {
            array.swap(i, i/2);
            goBackUp(array, i/2);
        }
    }
    public void goBackDown(ObservableArray array, int element, int i) {
        int formula = 2 * i +1;
        int max;
        if (formula < element) {
            if (array.compare(formula, 2*i).equals(Order.Higher)) {
                max = formula;
            } else {
                max = 2 * i;
            }
            if (array.compare(max, i).equals(Order.Higher)) {
                array.swap(max, i);
                goBackDown(array, element, max);
            }
        }
    }
}
