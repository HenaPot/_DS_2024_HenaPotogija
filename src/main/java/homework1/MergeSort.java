package homework1;

import java.util.Comparator;

public class MergeSort {
    public static void sort(Entry[] entries, Comparator<Entry> comparator) {
        System.out.println("Sorting the entries...");
        Entry[] aux = new Entry[entries.length];
        sort(entries, aux, 0, entries.length - 1);
    }

    private static void sort(Entry[] elements, Entry[] aux, int low, int high) {
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;
        sort(elements, aux, low, mid);
        sort(elements, aux, mid + 1, high);
        merge(elements, aux, low, mid, high);
    }

    /* Merge the two sorted sub-arrays into a larger sorted (sub)array */
    private static void merge(Entry[] elements, Entry[] aux, int low, int mid, int high) {
        for (int k = low; k <= high; k++) {
            aux[k] = elements[k];
        }

        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                elements[k] = aux[j++];
            } else if (j > high) {
                elements[k] = aux[i++];
            } else if (aux[j].compareTo(aux[i]) < 0) {
                elements[k] = aux[j++];
            } else {
                elements[k] = aux[i++];
            }
        }
    }
}