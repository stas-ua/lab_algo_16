/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs_algo_16;

/**
 *
 * @author poberezhniys
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println("njdvjdsv");
        int arr[] = {5, 2, 9, 1, 4, 7, 3, 6, 8, 0};

        for (int i = 0; i < arr.length; i++) {

            //arr[i] = i+1;
            System.out.println(arr[i]);
        }
        System.out.println("--------------------");
        mergeSort2(arr);
        for (int e : arr) {
            System.out.println(e);
        }
    }

    private static class Dim {

        int lBnd;
        int rBnd;

        public Dim() {
        }

        ;
        public Dim(int l, int r) {
            lBnd = l;
            rBnd = r;
        }
    }

    public static void mergeSort(int arr[]) {
        Dim d = new Dim(0, arr.length - 1);
        mergeSort(arr, d);
    }

    public static void mergeSort(int arr[], Dim d) {
        int size = d.rBnd - d.lBnd + 1;
        if (size > 1) {
            Dim ld = new Dim(d.lBnd, d.lBnd + size / 2 - 1);
            Dim rd = new Dim(d.lBnd + size / 2, d.rBnd);
            mergeSort(arr, ld);
            mergeSort(arr, rd);
            int newArr[] = new int[size];
            int iL = ld.lBnd;
            int iR = rd.lBnd;
            for (int i = 0; i < size; i++) {
                if (iL > ld.rBnd) {
                    newArr[i] = arr[iR];
                } else if (iR > rd.rBnd) {
                    newArr[i] = arr[iL];
                } else if (arr[iL] < arr[iR]) {
                    newArr[i] = arr[iL++];
                } else {
                    newArr[i] = arr[iR++];
                }
            }
            for (int i = d.lBnd, j = 0; i <= d.rBnd; i++, j++) {
                arr[i] = newArr[j];
            }
        }
    }

    public static void mergeSort2(int arr[]) {
        int size = arr.length;
        Dim d = new Dim(0, size - 1);
        int arrNew[] = new int[size];
        mergeSort2(arr, arrNew, d);
        arr = arrNew;
    }

    public static void mergeSort2(int arr[], int arrNew[], Dim d) {
        int size = d.rBnd - d.lBnd + 1;
        if (size > 1) {
            Dim ld = new Dim(d.lBnd, d.lBnd + size / 2 - 1);
            Dim rd = new Dim(d.lBnd + size / 2, d.rBnd);
            mergeSort2(arr, arrNew, ld);
            mergeSort2(arr, arrNew, rd);
            //int newArr[] = new int[size];
            int iL = ld.lBnd;
            int iR = rd.lBnd;
            for (int i = d.lBnd; i <= d.rBnd; i++) {
                if (iL > ld.rBnd) {
                    arrNew[i] = arr[iR];
                } else if (iR > rd.rBnd) {
                    arrNew[i] = arr[iL];
                } else if (arr[iL] < arr[iR]) {
                    arrNew[i] = arr[iL++];
                } else {
                    arrNew[i] = arr[iR++];
                }
            }
        } else {
            arrNew[d.lBnd] = arr[d.lBnd];
        }
    }

    public static int[] mergeSort3(int arr[],  Dim d) {
        int size = d.rBnd - d.lBnd + 1;
        int newArr[] = new int[size];
        if (size > 1) {
            Dim ld = new Dim(d.lBnd, d.lBnd + size / 2 - 1);
            Dim rd = new Dim(d.lBnd + size / 2, d.rBnd);
            int arrL[] = mergeSort3(arr, ld);
            int arrR[] = mergeSort3(arr, rd);
            
            int iL = 0, iR = 0;
            int lSize = arrL.length, rSize = arrR.length;
            for (int i = 0; i < size; i++) {
                if (iL >= lSize) {
                    newArr[i] = arrR[iR];
                } else if (iR >= rSize) {
                    newArr[i] = arrL[iL];
                } else if (arr[iL] < arr[iR]) {
                    newArr[i] = arrL[iL++];
                } else {
                    newArr[i] = arrR[iR++];
                }
            }
        } else {
            newArr[d.lBnd] = arr[d.lBnd];
        }
        return newArr;
    }
}
