package com.example.demo1;

public class SV {
	private int ID;
	private int HoVaTen;
	private int Lop_ID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getHoVaTen() {
		return HoVaTen;
	}
	public void setHoVaTen(int hoVaTen) {
		HoVaTen = hoVaTen;
	}
	public int getLop_ID() {
		return Lop_ID;
	}
	public void setLop_ID(int lop_ID) {
		Lop_ID = lop_ID;
	}
	@Override
	public String toString() {
		return "SV [ID=" + ID + ", HoVaTen=" + HoVaTen + ", Lop_ID=" + Lop_ID + "]";
	}
}
