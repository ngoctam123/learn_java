package fa.begin2108.app;

import fa.begin2108.bean.Children;
import fa.begin2108.bean.Parent;

public class TestApp {

    public static void main(String[] args) {
        Parent p = new Parent();
        p.setId("C01");
        p.setName("child01");
        
        Children c = new Children();
        
        ///////////////////////////////////
        
        Children c1 = (Children) p;
        c1.setAddress("Child DN");
        
        //p = c;
        
        printTest(p);
    }
    
    
    public static void printTest(Parent p) {
        if (p instanceof Children) {
            Children c = (Children) p;
            System.out.println("This is children");
            System.out.println(c.getAddress());
        } else {
            System.out.println("This is parent");
            System.out.println(p.getName());
        }
    }
}
