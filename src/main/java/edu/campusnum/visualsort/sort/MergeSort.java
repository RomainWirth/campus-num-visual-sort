package edu.campusnum.visualsort.sort;

import edu.campusnum.visualsort.model.ObservableArray;
import edu.campusnum.visualsort.model.Order;
import javafx.beans.property.adapter.ReadOnlyJavaBeanStringProperty;

/**
 * Created by Web 74 all right reserved
 * User: vincent
 * Date: 27/07/2023
 * Time: 16:31
 */
public class MergeSort implements SortAlgorithm{
    @Override
    public void sort(ObservableArray array) {
        if (array.getLength() > 1) {
            int length = array.getLength();
            int iLeft = 0; // left part array
            int iRight = length / 2; // right part array
            int iEnd = length - iRight;
            ObservableArray left = array.slice(iLeft, iRight);
//            System.out.println(left);
            ObservableArray right = array.slice(iRight, iEnd);
//            System.out.println(right);
            sort(left);
            sort(right);

            while (iRight - iLeft > 0 && array.getLength() - iRight > 0) {
                if (array.compare(iLeft, iRight).equals(Order.Higher)) {
                    for (int j = iRight; j > iLeft; j--) {
                        array.swap(j, j - 1);
                    }
                    iRight++;
                }
                iLeft++;
            }
        }
    }
}
