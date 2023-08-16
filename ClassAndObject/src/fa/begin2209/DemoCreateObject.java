package fa.begin2209;

import java.util.ArrayList;
import java.util.Scanner;

public class DemoCreateObject {

    public static void main(String[] args) {
        /*
         * Tao ra 1 doi tuong hoc sinh
         * Truy cap (in ra) thong tin cua doi tuong vua tao
         */
        /*
        HocSinh hs1 = new HocSinh();
        System.out.println("Ma hoc sinh: " + hs1.MaHocSinh);
        System.out.println("Ten hoc sinh: " + hs1.TenHocSinh);
        System.out.println("Tuoi: " + hs1.Tuoi);
        System.out.println("Dia chi: " + hs1.DiaChi);
        */
        
        /*
         * Demo tao 1 list doi tuong, nhap vao thong tin cua
         * tung doi tuong va in ra toan bo thong tin cua cac doi tuong
         */
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao so luong hoc sinh: ");
        int hsNumber = sc.nextInt();
        sc.nextLine();
        
        //Tao List de chua cac hoc sinh
        ArrayList<HocSinh> hsList = new ArrayList();
        
        /*
         *Nhap thong tin cho so luong hoc sinh
         */
        
        for (int i = 0; i < hsNumber; i++) {
            System.out.println("Nhap thong tin hoc sinh thu " + (i+1));
            
            //Tao hoc sinh moi
            HocSinh hs = new HocSinh();
            
            //Nhap thong tin cho hoc sinh vua tao
            System.out.print("Nhap ma hoc sinh: ");
            hs.MaHocSinh = sc.nextLine();
            
            System.out.print("Nhap ten hoc sinh: ");
            hs.TenHocSinh = sc.nextLine();
            
            System.out.print("Nhap tuoi: ");
            hs.Tuoi = sc.nextInt();
            sc.nextLine();
            
            System.out.print("Nhap dia chi: ");
            hs.DiaChi = sc.nextLine();
            
            hsList.add(hs);
        }
        
        /*
         * In ra thong tin cac hoc sinh
         */
        for (int i = 0; i < hsList.size(); i++) {
            System.out.println("=======Thong tin hoc sinh " + (i+1) + "=======");
            HocSinh hs = hsList.get(i);
            System.out.println("Ma hoc sinh: " + hs.MaHocSinh);
            System.out.println("Ten hoc sinh: " + hs.TenHocSinh);
            System.out.println("Tuoi hoc sinh: " + hs.Tuoi);
            System.out.println("Dia chi: " + hs.DiaChi);
            System.out.println("Phuong tien di hoc");
            hs.diHoc();
        }
        
        /*
         * Nhap thong tin cho hoc sinh
         */
        for (int i = 0; i < hsNumber; i++) {
            HocSinh hs = new HocSinh();
            hs.inputHocSinh();
            
            hsList.add(hs);
        }
        
        /*
         * In ra thong tin cua hoc sinh
         */
        for (int i = 0; i < hsList.size(); i++) {
            HocSinh hs = hsList.get(i);
            hs.printHocSinh();
        }
        
        
        HocSinh hs1 = new HocSinh();
        hs1.inputHocSinh();
        
        
        
        
        HocSinh hs2 = new HocSinh();
        hs2.inputHocSinh();
        
        
        
        /*
         * Nhap thong tin hoc sinh, nhap den khi nao khong muon nhap nua thi dung
         */
        ArrayList<HocSinh> hsList1 = new ArrayList();
        String choice = "";
        do {
        	System.out.println("Nhap thong tin hoc sinh");
            
            //Tao hoc sinh moi
            HocSinh hs = new HocSinh();
            
            //Nhap thong tin cho hoc sinh vua tao
            System.out.print("Nhap ma hoc sinh: ");
            hs.MaHocSinh = sc.nextLine();
            
            System.out.print("Nhap ten hoc sinh: ");
            hs.TenHocSinh = sc.nextLine();
            
            System.out.print("Nhap tuoi: ");
            hs.Tuoi = sc.nextInt();
            sc.nextLine();
            
            System.out.print("Nhap dia chi: ");
            hs.DiaChi = sc.nextLine();
            
            hsList1.add(hs);
            
            System.out.println("Ban co muon nhap tiep khong ? (y: co, n: khong)");
            choice = sc.nextLine();
		} while (choice.equals("y") || choice.equals("Y"));
        
    }
}
