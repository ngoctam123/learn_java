package fa.begin2108.bean;

public class Test {
    
    static NhanVien nv;
    
    public static void method1() {
        Test.nv = new NhanVien();
        Test.nv.setMaNV("MNV00001");
        Test.nv.setTenNV("Nguyen Van A");
        Test.nv.setTuoiNV(20);
        
        
    }
    
    
    public static void method2() {
        Test.nv.setMaNV("MNV00002");
    }
    
    

    public static void main(String[] args) {
        //Doan code nay call method1
        method1();
        
        System.out.println("Thong tin nhan vien sau khi call method1: ");
        System.out.println(Test.nv.toString());
        
        //////////////////////////////////////
        //                                  //
        //       Implement more process     //
        //                                  //
        //////////////////////////////////////
       
        //Sau khi thuc hien 1 loat code phia tren thi thuc hien call method2()
        method2();
        //==> Tai day gia tri thuoc tinh cua nv da bi thay doi khi call method2() --> Gia tri khong con dung
        
        //////////////////////////////////////
        //                                  //
        //       Implement more process     //
        //                                  //
        //////////////////////////////////////
        
        //Sau khi thuc hien 1 loat code phia tren thi su dung lai bien "nv".
        //Tai day gia tri thuoc tinh da khong con nhu truoc nua, no da bi thay doi
        System.out.println("Thong tin nhan vien sau khi call method1: ");
        System.out.println(Test.nv.toString());
        
        
        Children c = new Children();
    }
}
