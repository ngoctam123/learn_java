package fa.begin2108.bean;

public class Begin2206App {

    public static void main(String[] args) {
        Parent p1 = new Parent();
        p1.id = "P001";
        System.out.println(p1.id);
        
        HocSinh.number += 10;
        
        HocSinh hs = new HocSinh();
        hs.printHocSinh();
        System.out.println(hs.number);
        
        HocSinh hs2 = new HocSinh("HS001", "Nguyen Van A");
        hs2.printHocSinh();
        hs2.number += 1;
        
        HocSinh hs3 = new HocSinh("HS002", "Tran Thi B", 20, "Da Nang");
        hs3.printHocSinh();
        
        System.out.println(hs3.number);
        System.out.println(hs2.number);
        
    }
    
    public static final double SO_PI;
    static {
        SO_PI = 3.14;
    }
}
