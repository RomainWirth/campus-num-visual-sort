package edu.campusnum.visualsort.sort;

import edu.campusnum.visualsort.model.ObservableArray;
import static edu.campusnum.visualsort.model.Order.Higher;

/**
 * Created by Web 74 all right reserved
 * User: vincent
 * Date: 27/07/2023
 * Time: 16:31
 */
public class SelectionSort implements SortAlgorithm{
    @Override
    public void sort(ObservableArray array) {
        int i;
        int n = array.getLength();
        for (i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                // array.compare(j, min) => array.get(j) > array.get(min)
//                array.compare(min, j); // => array.get(j) < array.get(min)
//                System.out.println(array.compare(min, j));
                if(array.compare(min, j).equals(Higher)) {
                    min = j;
                }
            }
            array.swap(i, min);
        }
    }
}
