package arrays_pack;

import java.util.HashMap;
import java.util.Map;

public class SecondMinMax <T extends  Comparable<T>>{
    public Map<String,Object> findSecondMinMax(T[] arr) {

        T largest=arr[0];
        T secondLargest=arr[1];
        T minimum=arr[arr.length/2];
        T secondMin=arr[1];

        for (int i = 0; i < arr.length; i++) {

            if (arr[i].compareTo(largest) > 0) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i].compareTo(secondLargest) >0  && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {

            if (arr[i].compareTo(minimum) < 0) {
                secondMin = minimum;
                minimum = arr[i];
            } else if (arr[i].compareTo(secondMin) <0  && arr[i] != minimum) {
                secondMin = arr[i];
            }
        }
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("Second Largest", secondLargest==largest?" Not Present":secondLargest);
        returnMap.put("Second Minimum", secondMin==minimum?" Not Present":secondMin);

        return returnMap;
    }
}
