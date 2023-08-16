package topgun.entities;

public class UsedPhone extends Phone {
    private String classification;
    private String condition;
    private String warrantyPackage;

    /**
     * author Ngoc Tam.
     * @time 8:30:16 AM
     * @date May 18, 2023
     */
    public UsedPhone(String id, String name, String size, String chipName, String ramSize, String storageSize, String manufacturer, String price, String classification, String condition, String warrantyPackage) {
        super(id, name, size, chipName, ramSize, storageSize, manufacturer, price);
        this.classification = classification;
        this.condition = condition;
        this.warrantyPackage = warrantyPackage;
    }

    public String getClassification() {
        return classification;
    }

    public String getCondition() {
        return condition;
    }

    public String getWarrantyPackage() {
        return warrantyPackage;
    }
}
