package attri.girish.gadgetworldapp.model;

public class Image
{
    private int imageid;
    private int productid;
    private String url;
    private String tag;

    public Image(int imageid, int productid, String url, String tag) {
        this.imageid = imageid;
        this.productid = productid;
        this.url = url;
        this.tag = tag;
    }

    public Image() {
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}