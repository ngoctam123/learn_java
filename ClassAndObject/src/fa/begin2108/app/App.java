package fa.begin2108.app;

import java.util.Scanner;

import fa.begin2108.bean.HocSinh;
import fa.begin2108.bean.Parent;

public class App {

    public static void main(String[] args) {
        //System.out.println("Hello world HocSinh");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        HocSinh hs1 = new HocSinh();
        System.out.println(hs1.MaHocSinh);
        System.out.println(hs1.TenHocSinh);
        System.out.println(hs1.Tuoi);
        System.out.println(hs1.DiaChi);
        //System.out.println(System.identityHashCode(hs1));
        
        //HocSinh hs2 = new HocSinh();
        //System.out.println(System.identityHashCode(hs2));
        //System.out.println(hs1.hashCode());
        hs1.MaHocSinh = "MHS0000";
        hs1.TenHocSinh = "Hoc Sinh 1";
        System.out.println(hs1.MaHocSinh);
        System.out.println(hs1.TenHocSinh);
        System.out.println(hs1.Tuoi);
        System.out.println(hs1.DiaChi);
        
        String[] str = {"robot1", "robot2"};
        
        HocSinh hocsinh1 = new HocSinh();
        HocSinh hocsinh2 = new HocSinh();
        hocsinh1.TenHocSinh = str[0];
        hocsinh2.TenHocSinh = str[1];
        
        HocSinh hsx = null;
        //System.out.println(hsx.DiaChi); // ==> Exception in thread "main" java.lang.NullPointerException
        
        HocSinh[] hsArr = new HocSinh[10];
        
        HocSinh hs2 = new HocSinh("MHS0001", "Nguyen Van A", 18, "Da Nang");
        System.out.println("Ma Hoc Sinh: " + hs2.MaHocSinh);
        System.out.println("Ten Hoc Sinh: " + hs2.TenHocSinh);
        System.out.println("Tuoi" + hs2.Tuoi);
        System.out.println("Dia chi: " + hs2.DiaChi);
        
        HocSinh hs3 = new HocSinh("MHS0001", "Nguyen Van B");
        System.out.println(hs3.hashCode()); //Ma bam duoc tao ra, mac dinh se lay giong dia chi luu o nho
        System.out.println(System.identityHashCode(hs3)); //Dia chi luu o nho
        
        HocSinh hs4;
        /////////
        
        hs4 = new HocSinh();
        
        HocSinh hs5 = null;
        //System.out.println(hs5.MaHocSinh); // ==> Null pointer exception
        
        HocSinh hs6 = hs2;
        hs6.Tuoi = 20;
        System.out.println(hs6.Tuoi);
        System.out.println(hs2.Tuoi);
        
        HocSinh hs7 = new HocSinh("MHS0007", "Hoc Sinh 7", 18, "Da Nang");
        hs6 = hs7;
        System.out.println(hs6.Tuoi);
        System.out.println(hs2.Tuoi);
        
        HocSinh hs8 = new HocSinh();
        hs8.MaHocSinh = hs7.MaHocSinh;
        hs8.TenHocSinh = hs7.TenHocSinh;
        hs8.Tuoi = hs7.Tuoi;
        hs8.DiaChi = hs7.DiaChi;
        hs8.MaHocSinh = "MHS0008";
        System.out.println(hs7.MaHocSinh);
        System.out.println(hs8.MaHocSinh);
        
        //Sample ve method
        HocSinh hocSinh1 = new HocSinh("MHS0001", "HocSinh1", 18, "Da Nang");
        HocSinh hocSinh2 = new HocSinh("MHS0002", "HocSinh2", 20, "Quang Nam");
        HocSinh hocSinh3 = new HocSinh("MHS0003", "HocSinh3", 21, "Quang Ngai");
        HocSinh hocSinh4 = null;
        
        hocSinh1.showThongTinHocSinh();
        hocSinh1.diHoc();
        
        hocSinh2.showThongTinHocSinh();
        hocSinh2.diHoc();
        
        hocSinh3.showThongTinHocSinh();
        hocSinh3.diHoc();
        
        //hocSinh4.diHoc(); ==> NullPointerException vi chua new doi tuong
        
        
        //Tao mang hoc sinh
        HocSinh[] hsArray = new HocSinh[4];
        //hsArray[0].diHoc(); ==> NullPointerException vi chua khoi tao doi tuong cho phan tu trong mang
        for (int i = 0; i < hsArray.length; i++) {
            HocSinh hocSinhElement = new HocSinh();
            hocSinhElement.MaHocSinh = "MHS000" + (i+1);
            hocSinhElement.TenHocSinh = "TenHocSinh" + (i+1);
            hocSinhElement.Tuoi = 18 + (i+1);
            hocSinhElement.DiaChi = "Da Nang";
            hsArray[i] = hocSinhElement;
        }
        
        //Truy xuat doi tuong trong mang
        for (int i = 0; i < hsArray.length; i++) {
            HocSinh hocSinhElement = hsArray[i];
            System.out.println("Ma Hoc Sinh: " + hocSinhElement.MaHocSinh);
            System.out.println("Ten Hoc Sinh: " + hocSinhElement.TenHocSinh);
            System.out.println("Tuoi" + hocSinhElement.Tuoi);
            System.out.println("Dia chi: " + hocSinhElement.DiaChi);
        }
        
        hsArray[0] = hs7;
        System.out.println(hsArray[0].MaHocSinh);
        hs8 = hsArray[1];
        System.out.println(hs8.MaHocSinh);
        hs8.MaHocSinh = "MHS0008";
        System.out.println(hsArray[1].MaHocSinh);
        hsArray[4] = new HocSinh("MHS0004", "HocSinh4", 23, "Da Nang");
        hsArray[4].diHoc();
    }
    
    public static void tinhDiemCong(HocSinh hs) {
        if (hs.Tuoi < 20) {
            System.out.println("Hoc sinh " + hs.TenHocSinh + " duoc cong them 3 diem");
        }
    }
}