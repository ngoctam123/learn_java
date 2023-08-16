package fa.begin2108.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PublicClass {

    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        
        List<Integer> b = lst.subList(0, 4);
        Arrays.toString(b.toArray());
    }
}
