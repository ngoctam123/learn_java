package topgun.entities;

public class GreyPhone extends Phone {
    private String importCountry;
    private String warrantyPackage;

    /**
     * author Ngoc Tam.
     * @time 8:23:16 AM
     * @date May 18, 2023
     */
    public GreyPhone(String id, String name, String size, String chipName, String ramSize, String storageSize, String manufacturer, String price, String importCountry, String warrantyPackage) {
        super(id, name, size, chipName, ramSize, storageSize, manufacturer, price);
        this.importCountry = importCountry;
        this.warrantyPackage = warrantyPackage;
    }

    public String getImportCountry() {
        return importCountry;
    }

    public String getWarrantyPackage() {
        return warrantyPackage;
    }
}
