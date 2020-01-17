package utils;

import java.util.ArrayList;
import java.util.List;

public class utility {
    public static List<Integer> getListByInteger(Integer index) {
        List<Integer> target = new ArrayList<Integer>();
        for (int i = 0; i < index; i++) {
            target.add(i);
        }
        return target;
    }
}
