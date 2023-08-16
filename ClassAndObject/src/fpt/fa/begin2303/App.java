package fpt.fa.begin2303;

import fa.begin2209.HocSinh;

public class App {

	public static void main(String[] args) {
		HocSinh hs = new HocSinh();
		hs.setMaHocSinh("MSV01");
		System.out.println(hs.getMaHocSinh());
		
		System.out.println(hs.number);
		
		HocSinh hs2 = new HocSinh();
		hs2.number = 10;
		
		System.out.println("hs2.number = " + hs2.number);
		System.out.println("hs.number = " + hs.number);
		
		HocSinh.number = 100;
		System.out.println("HocSinh.number = " + HocSinh.number);
		System.out.println("hs2.number = " + hs2.number);
		System.out.println("hs.number = " + hs.number);
	}
}
