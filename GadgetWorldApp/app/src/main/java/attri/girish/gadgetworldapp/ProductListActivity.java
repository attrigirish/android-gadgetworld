package attri.girish.gadgetworldapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;

import attri.girish.gadgetworldapp.adapter.ProductAdapter;
import attri.girish.gadgetworldapp.helper.DownloadTask;
import attri.girish.gadgetworldapp.helper.OnDownloadTaskCompletedListener;
import attri.girish.gadgetworldapp.model.Image;
import attri.girish.gadgetworldapp.model.Product;

public class ProductListActivity extends AppCompatActivity implements OnDownloadTaskCompletedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        Intent intent = getIntent();
        int categoryid=intent.getIntExtra("categoryid",0);

        try {
            URL url = new URL("http://gadgetworld.000webhostapp.com/getproducts.php?cid=" + categoryid);
            DownloadTask task = new DownloadTask(this);
            task.execute(url);
        }
        catch (Exception e)
        {
        }
    }

    @Override
    public void onDownloadTaskCompleted(String s) {
        try {
            JSONArray array = new JSONArray(s);
            ArrayList<Product> products = new ArrayList<Product>();
            for(int i=0;i<array.length();i++)
            {
                JSONObject object = array.getJSONObject(i);
                int productid=object.getInt("productid");
                int brandid=object.getInt("brandid");
                int categoryid=object.getInt("categoryid");
                String name=object.getString("name");
                Double price = object.getDouble("price");
                ArrayList<Image> images=new ArrayList<>();

                JSONArray imagesArray = object.getJSONArray("images");
                for(int j=0;j<imagesArray.length();j++)
                {
                    JSONObject imageObject = imagesArray.getJSONObject(j);
                    int imageid=imageObject.getInt("imageid");
                    String url="http://gadgetworld.000webhostapp.com/images/"+imageObject.getString("url");
                    String tag=imageObject.getString("tag");

                    Image image = new Image(imageid,productid,url,tag);
                    images.add(image);
                }

                Product product = new Product(productid,brandid,categoryid,name,price,images);
                products.add(product);
            }



            ProductAdapter adapter = new ProductAdapter(ProductListActivity.this,products);
            GridView gridView = findViewById(R.id.gridProduct);
            gridView.setAdapter(adapter);
        }
        catch(Exception e)
        {

        }
    }
}
