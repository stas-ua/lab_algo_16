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
        int arr[] = {5,2,9,1,4,7,3,6,8,0};
        
        for (int i = 0; i< arr.length; i++){
            
            //arr[i] = i+1;
            System.out.println(arr[i]);
        }        
        System.out.println("--------------------");        
        mergeSort(arr);        
        for (int e:arr){
            System.out.println(e);
        }
    }
    
    private static class Dim{
        int lBnd;
        int rBnd;
        public Dim(){};
        public Dim(int l , int r){
            lBnd = l;
            rBnd = r;
        }
    }
    public static  void mergeSort(int arr[]){
        Dim d = new Dim(0,arr.length-1);
        mergeSort(arr, d);
    }
    public static void mergeSort(int arr[], Dim d){
        int size = d.rBnd - d.lBnd + 1;
        if(size>1){
            Dim ld  = new Dim(d.lBnd, d.lBnd + size/2-1);
            Dim rd  = new Dim( d.lBnd + size/2, d.rBnd);  
            mergeSort(arr, ld);
            mergeSort(arr, rd);
            int newArr[] = new int[size];
            int iL = ld.lBnd;
            int iR = rd.lBnd;
            for(int i = 0; i<size; i++){
                if(iL>ld.rBnd){
                    newArr[i] = arr[iR];
                }else if(iR>rd.rBnd){
                    newArr[i] = arr[iL];
                }else if(arr[iL]<arr[iR]){
                    newArr[i] = arr[iL++];
                }else{
                    newArr[i] = arr[iR++];
                }                
            }
            for(int i = d.lBnd, j = 0;i<=d.rBnd;i++,j++){
                arr[i] = newArr[j];
            }
        } 
    }
    
    
}
