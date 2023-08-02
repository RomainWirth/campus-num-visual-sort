package edu.campusnum.visualsort.sort;

import edu.campusnum.visualsort.model.ObservableArray;
import edu.campusnum.visualsort.model.Order;

/**
 * Created by Web 74 all right reserved
 * User: vincent
 * Date: 27/07/2023
 * Time: 16:31
 */
public class QuickSort implements SortAlgorithm{
    @Override
    public void sort(ObservableArray array) {
        int first = 0;
        int n = array.getLength();
        int last = n - 1;
        quickSort(array);
    }

    /**
     * Method qui implémente le quickSort
     * Elle prend un index partitionné = index ordronné grâce au pivot qui permet de réorganiser les éléments
     * => voir la méthode "partition"
     * @param array
     * => tableau à trier
     * @param first
     * => index de départ
     * @param last
     * => index de fin
     */
    public void quickSort(ObservableArray array) {
        if (array.getLength() > 1) {
            int partitionIndex = partition(array);
            // trie les éléments de la  séparément avant et après la partition, de manière récursive
            quickSort(array.slice(0,partitionIndex));
            if((array.getLength() - partitionIndex - 1) > 1) {
                quickSort(array.slice(partitionIndex + 1, array.getLength() - partitionIndex - 1));
            }
            System.out.println(partitionIndex);
        }
    }

    /**
     * Cette méthode prend l'élément au dernier index comme pivot.
     * Elle place le pivot à sa position correcte dans le tableau trié,
     * et place les éléments plus petit que lui à sa gauche, et les plus grand éléments à sa droite.
     * Cette méthode prend 3 paramètres : le tableau à trier, le premier index et le dernier index.
     * @param array
     * => tableau à trier
     * @param first
     * => premier index
     * @param last
     * => dernier index
     * @return
     * => retourne la partition de l'index à la bonne place
     */
    public int partition(ObservableArray array) {
        // initialisation du pivot : dernier index
        int pivot = array.getLength()-1;
        // index du plus petit élément et indique la position correcte du pivot
        int i = - 1;
        // index de l'élément courant
        for (int j = 0; j <= pivot - 1; j++) {
            // si l'élément courant est plus petit que le pivot
            if (array.compare(pivot, j).equals(Order.Higher)) {
                // on incrémente de l'index du plus petit élément
                i++;
                array.swap(i, j);
            }
        }
        array.swap(i+1, pivot);
        return (i + 1);
    }
}
