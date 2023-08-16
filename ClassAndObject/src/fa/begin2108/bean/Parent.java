package fa.begin2108.bean;

public class Parent {

    protected String id;
    private String name;
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
    public Parent() {
        System.out.println("Constructor Parent");
    }
    
    public void showInfo() {
        System.out.println("ID: " + this.id);
    }
    
}
