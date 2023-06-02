package arrays_pack;

import java.util.List;

public class GenSort <T extends Comparable<T>>{
    public List<T> bubbleSort(List<T> arr){
        Integer len = arr.size()-1;
        for (Integer i = 0;i<len;i++){
            for (Integer j =0;j<len -i;j++){
                if(arr.get(j).compareTo(arr.get(j+1))>0){
                    T temp = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j+1, temp);
                }
            }
        }
        return arr;
    }
    public T[] bubbleSort(T[] arr){
        Integer len = arr.length-1;
        for (Integer i = 0;i<len;i++){
            for (Integer j =0;j<len -i;j++){
                if(arr[j].compareTo(arr[j+1])>0){
                    T temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]= temp;
                }
            }
        }
        return arr;
    }
    public List<T> insertionSort(List<T> arr){
        Integer len = arr.size()-1;
        for (Integer i = 0;i<len;i++){
            T key  = arr.get(i);
            Integer j = i-1;
            while(j>=0 && arr.get(j).compareTo(key)>0){
                arr.set(j+1, arr.get(j));
                j--;
            }
            arr.set(j+1, key);
        }
        return arr;
    }
    public T[] insertionSort(T[] arr){
        Integer len = arr.length-1;
        for (Integer i = 0;i<len;i++){
            T key  = arr[i];
            Integer j = i-1;
            while(j>=0 && arr[j].compareTo(key)>0){
                arr[j+1] =  arr[j];
                j--;
            }
            arr[j+1] =  key;
        }
        return arr;
    }
    public List<T> selectionSort(List<T> arr){
        Integer len = arr.size() -1;
        for (Integer i =0;i< len;i++){
            Integer min_index = 1;
            for (Integer j =i+1; j<len ;j++ )
                if(arr.get(j).compareTo(arr.get(j+1))>0)
                    min_index=j;
            T temp = arr.get(min_index);
            arr.set(min_index, arr.get(i));
            arr.set(i, temp);
        }
        return arr;
    }
    public T[] selectionSort(T[] arr){
        Integer len = arr.length -1;
        for (Integer i =0;i< len;i++){
            Integer min_index = 1;
            for (Integer j =i+1; j<len ;j++ )
                if(arr[j].compareTo(arr[j+1])>0)
                    min_index=j;
            T temp = arr[min_index];
            arr[min_index] =  arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
