package Uke17_18;

import java.util.Arrays;
import java.util.PriorityQueue;

    public class Oppgave1 {

        // ─────────────────────────────────────────────────────────
        // 1. INSERTION SORT – modifisert
        //
        // Idé: bygg sortert del fra venstre, stopp etter k elementer.
        // For hvert nytt element i, sett det inn på riktig plass
        // blant de i første elementene. Etter i == k er de k første
        // plassene sortert og vi er ferdige.
        //
        // Orden: O(n * k)
        //   - Vi itererer gjennom alle n elementer (ytre løkke)
        //   - Hvert element kan flytte seg gjennom opptil k plasser (indre løkke)
        //   - For k=1 → O(n), for k=n → O(n²)
        // ─────────────────────────────────────────────────────────
        public static int[] insertionSortK(int[] arr, int k) {
            int[] a = arr.clone();
            for (int i = 1; i < a.length; i++) {
                int key = a[i];
                int j = i - 1;
                // flytt større elementer én plass til høyre
                while (j >= 0 && a[j] > key) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = key;
                if (i >= k) break; // de k første plassene er nå sortert
            }
            return Arrays.copyOfRange(a, 0, k);
        }

        // ─────────────────────────────────────────────────────────
        // 2. SELECTION SORT – modifisert
        //
        // Idé: finn minimum i usortert del og plasser det fremst.
        // Gjør dette kun k ganger i stedet for n ganger.
        //
        // Orden: O(n * k)
        //   - k runder der hver runde scanner n-i gjenstående elementer
        //   - Totalt ≈ k*n sammenligninger
        //   - For k=1 → O(n), for k=n → O(n²)
        // ─────────────────────────────────────────────────────────
        public static int[] selectionSortK(int[] arr, int k) {
            int[] a = arr.clone();
            for (int i = 0; i < k; i++) {
                int minIdx = i;
                // finn minste element i usortert del
                for (int j = i + 1; j < a.length; j++) {
                    if (a[j] < a[minIdx]) {
                        minIdx = j;
                    }
                }
                // bytt minste inn på posisjon i
                int temp = a[i];
                a[i] = a[minIdx];
                a[minIdx] = temp;
            }
            return Arrays.copyOfRange(a, 0, k);
        }

        // ─────────────────────────────────────────────────────────
        // 3. HEAP SORT – modifisert (min-haug)
        //
        // Idé: bygg en min-haug av alle n elementer, hent ut
        // minimum k ganger. Minimum ligger alltid øverst i haugen.
        //
        // Orden: O(n + k * log n)
        //   - Bygge haugen (heapify): O(n)
        //   - Hente ut k minste: k * O(log n)
        //   - For k=1 → O(n), for k=n → O(n log n)
        //   - Alltid bedre enn insertion/selection for store n
        // ─────────────────────────────────────────────────────────
        public static int[] heapSortK(int[] arr, int k) {
            // PriorityQueue er en min-haug som standard i Java
            // Sender alle elementer inn i konstruktøren → intern heapify O(n)
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for (int val : arr) {
                minHeap.add(val);
            }
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = minHeap.poll(); // hent og fjern minimum: O(log n)
            }
            return result;
        }

        // ─────────────────────────────────────────────────────────
        //test med eksempelet fra oppgaven
        // ─────────────────────────────────────────────────────────
        public static void main(String[] args) {
            int[] arr = {15, 8, 1, 9, 11, 5, 10, 12};
            int k = 3;

            System.out.println("Input:          " + Arrays.toString(arr));
            System.out.println("k = " + k);
            System.out.println();
            System.out.println("Insertion sort: " + Arrays.toString(insertionSortK(arr, k)));
            System.out.println("Selection sort: " + Arrays.toString(selectionSortK(arr, k)));
            System.out.println("Heap sort:      " + Arrays.toString(heapSortK(arr, k)));
        }
    }

