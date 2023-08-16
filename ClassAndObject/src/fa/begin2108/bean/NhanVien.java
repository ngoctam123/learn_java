package fa.begin2108.bean;

public class NhanVien {

    private String maNV;
    private String tenNV;
    private int tuoiNV;
    /**
     * @return the maNV
     */
    public String getMaNV() {
        return maNV;
    }
    /**
     * @param maNV the maNV to set
     */
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    /**
     * @return the tenNV
     */
    public String getTenNV() {
        return tenNV;
    }
    /**
     * @param tenNV the tenNV to set
     */
    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }
    /**
     * @return the tuoiNV
     */
    public int getTuoiNV() {
        return tuoiNV;
    }
    /**
     * @param tuoiNV the tuoiNV to set
     */
    public void setTuoiNV(int tuoiNV) {
        this.tuoiNV = tuoiNV;
    }
    
    @Override
    public String toString() {
        return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", tuoiNV=" + tuoiNV + "]";
    }
}
