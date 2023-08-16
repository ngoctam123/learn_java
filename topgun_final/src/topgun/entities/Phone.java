package topgun.entities;



public class Phone {
    

	private String id;
    private String name;
    private String size;
    private String chipName;
    private String ramSize;
    private String storageSize;
    private String manufacturer;
    private String price;
    /**
     * author Ngoc Tam.
     * @time 8:7:00 AM
     * @date May 18, 2023
     */

    public Phone(String id, String name, String size, String chipName, String ramSize, String storageSize, String manufacturer, String price) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.chipName = chipName;
        this.ramSize = ramSize;
        this.storageSize = storageSize;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getChipName() {
        return chipName;
    }

    public String getRamSize() {
        return ramSize;
    }

    public String getStorageSize() {
        return storageSize;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getPrice() {
        return price;
    }
    @Override
	public String toString() {
		return "Phone [id=" + id + ", name=" + name + ", size=" + size + ", chipName=" + chipName + ", ramSize="
				+ ramSize + ", storageSize=" + storageSize + ", manufacturer=" + manufacturer + ", price=" + price
				+ "]";
	}
    
    public void showInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Size: " + getSize());
        System.out.println("Chip name: " + getChipName());
        System.out.println("RAM size: " + getRamSize());
        System.out.println("Storage size: " + getStorageSize());
        System.out.println("Manufacturer: " + getManufacturer());
        System.out.println("Price: " + getPrice());
    }
}