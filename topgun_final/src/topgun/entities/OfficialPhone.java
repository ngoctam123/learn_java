package topgun.entities;

public class OfficialPhone extends Phone {
    private String warranty;
    private String warrantyScope;
    /**
     * author Ngoc Tam.
     * @time 8:19:00 AM
     * @date May 18, 2023
     */

    public OfficialPhone(String id, String name, String size, String chipName, String ramSize, String storageSize, String manufacturer, String price, String warranty, String warrantyScope) {
        super(id, name, size, chipName, ramSize, storageSize, manufacturer, price);
        this.warranty = warranty;
        this.warrantyScope = warrantyScope;
    }

    public String getWarranty() {
        return warranty;
    }

    public String getWarrantyScope() {
        return warrantyScope;
    }
}

