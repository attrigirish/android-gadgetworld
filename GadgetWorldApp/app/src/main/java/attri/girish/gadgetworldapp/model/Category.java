package attri.girish.gadgetworldapp.model;

public class Category
{
    private int categoryid;
    private String name;

    public Category(int categoryid, String name) {
        this.categoryid = categoryid;
        this.name = name;
    }

    public Category() {
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
