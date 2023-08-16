package fa.begin2108.bean;

import java.util.Scanner;

public class HocSinh {

    public String MaHocSinh;
    public String TenHocSinh;
    public int Tuoi;
    public String DiaChi;
    
    public static int number;
    
    public final String QUOC_GIA;

    public void diHoc() {
        if ("Da Nang".equals(DiaChi)) {
            System.out.println("Di hoc bang xe may");
        } else {
            System.out.println("Di hoc bang xe bus");
        }
    }

    public void dongTienHocPhi() {
        System.out.println("Tien hoc phi hang nam");
    }

    public void thiCuoiKy() {
        System.out.println("Tinh diem trung binh cuoi ky");
    }

    public void showThongTinHocSinh() {
        System.out.println("Ma Hoc Sinh: " + MaHocSinh);
        System.out.println("Ten Hoc Sinh: " + TenHocSinh);
        System.out.println("Tuoi" + Tuoi);
        System.out.println("Dia chi: " + DiaChi);
    }

    public HocSinh(String maHs, String tenHs, int tuoi, String diaChi) {
        MaHocSinh = maHs;
        TenHocSinh = tenHs;
        Tuoi = tuoi;
        DiaChi = diaChi;
        QUOC_GIA = "Viet Nam";
    }

    public HocSinh(String maHs, String tenHs) {
        MaHocSinh = maHs;
        TenHocSinh = tenHs;
        QUOC_GIA = "Viet Nam";
    }

    
    public HocSinh() {
        this.MaHocSinh = "xxxx";
        this.TenHocSinh = "Anonymouse";
        this.Tuoi = 0;
        this.DiaChi = null;
        QUOC_GIA = "Viet Nam";
    }

    /**
     * Input thong tin cho hoc sinh
     * @param sc
     */
    public void inputHocSinh() {
        Scanner sc = new Scanner(System.in);
        // Nhap thong tin cho hoc sinh vua tao
        System.out.print("Nhap ma hoc sinh: ");
        this.MaHocSinh = sc.nextLine();

        System.out.print("Nhap ten hoc sinh: ");
        this.TenHocSinh = sc.nextLine();

        System.out.print("Nhap tuoi: ");
        this.Tuoi = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhap dia chi: ");
        this.DiaChi = sc.nextLine();
    }
    
    /**
     * In ra thong tin cua hoc sinh
     */
    public void printHocSinh() {
        System.out.println("Ma hoc sinh: " + this.MaHocSinh);
        System.out.println("Ten hoc sinh: " + this.TenHocSinh);
        System.out.println("Tuoi hoc sinh: " + this.Tuoi);
        System.out.println("Dia chi: " + this.DiaChi);
        System.out.println("Phuong tien di this.hoc");
        this.diHoc();
    }
}
