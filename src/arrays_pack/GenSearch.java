package arrays_pack;

import java.util.List;

public class GenSearch<T extends Comparable<T>> {


    public Details LinearSearch(List<T> obj, T key) {
        for (int i = 0; i < obj.size(); i++) {
            if (obj.get(i).compareTo(key) == 0) {
                return new Details(i, true);
            }
        }
        return new Details(-1, false);
    }


    public Details LinearSearch(T[] obj, T key) {

        for (int i = 0; i < obj.length; i++) {
            if (obj[i].compareTo(key) == 0) {
                return new Details(i, true);
            }
        }
        return new Details(-1, false);
    }

    public Details binarySearch(List<T> obj, T key, Integer... len) {
        Integer first = len.length == 0 ? 0 : len[0];
        Integer last = len.length == 0 ? obj.size() - 1 : len[1];
        Integer mid = first + (last - first) / 2;
        if (obj.get(mid).compareTo(key) == 0) {
            return new Details(mid, true);
        }
        if (obj.get(mid).compareTo(key) > 0) {
            return binarySearch(obj, key, first, last - 1);

        }
        return binarySearch(obj, key, mid + 1, last);
    }

    public Details binarySearch(T[] obj, T key, Integer... len) {
        Integer first = len.length == 0 ? 0 : len[0];
        Integer last = len.length == 0 ? obj.length - 1 : len[1];
        Integer mid = first + (last - first) / 2;
        if (obj[mid].compareTo(key) == 0) {
            return new Details(mid, true);
        }
        if (obj[mid].compareTo(key) > 0) {
            return binarySearch(obj, key, first, last - 1);

        }
        return binarySearch(obj, key, mid + 1, last);


    }

    public Details sentinelSearch(List<T> obj, T key) {
        Integer len = obj.size();
        T last = obj.get(len - 1);
        obj.set(len - 1, key);
        Integer i = 0;

        while (obj.get(i).compareTo(key) != 0)
            i++;

        obj.set(len - 1, last);

        if ((i < len - 1) || (obj.get(len - 1).compareTo(key) == 0))
            return new Details(i, true);
        else
            return new Details(-1, false);

    }

    public Details sentinelSearch(T[] obj, T key) {
        Integer len = obj.length;
        T last = obj[len - 1];
        obj[len - 1] = key;
        Integer i = 0;

        while (obj[i].compareTo(key) != 0)
            i++;

        obj[len - 1] = last;

        if ((i < len - 1) || (obj[len - 1].compareTo(key) == 0))
            return new Details(i, true);
        else
            return new Details(-1, false);

    }

//    public Details interpolationSearch(List<T> obj,T key) {
//
//    }

//    public Details interpolationSearch(Number[] obj,Number key,Integer... p) {
//        Integer pos;
//        Integer lo = p.length==0?0:p[0];
//        Integer hi =p.length==0?obj.length-1:p[1];
//        if (lo <= hi && key.doubleValue()>= obj[lo].doubleValue() && key.doubleValue() <= obj[hi].doubleValue()) {
//
//            // Probing the position with keeping
//            // uniform distribution in mind.
//            pos = (int) (lo
//                                + (((hi - lo) / (obj[hi].doubleValue() - obj[lo].doubleValue()))
//                                * (key.doubleValue() - obj[lo].doubleValue())));
//
//            // Condition of target found
//            if (obj[pos] == key)
//                return new Details(pos,true);
//
//            // If x is larger, x is in right sub array
//            if (obj[pos].doubleValue() < key.doubleValue())
//                return interpolationSearch(obj, key,pos + 1, hi);
//
//            // If x is smaller, x is in left sub array
//            if (obj[pos].doubleValue() > key.doubleValue())
//                return interpolationSearch(obj,key, lo, pos - 1);
//        } return new Details(-1,false);
//    }
}
