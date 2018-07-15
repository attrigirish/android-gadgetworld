package attri.girish.gadgetworldapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;

import attri.girish.gadgetworldapp.adapter.CategoryAdapter;
import attri.girish.gadgetworldapp.helper.DownloadTask;
import attri.girish.gadgetworldapp.helper.OnDownloadTaskCompletedListener;
import attri.girish.gadgetworldapp.model.Category;

public class MainActivity extends AppCompatActivity implements OnDownloadTaskCompletedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            URL url = new URL("http://gadgetworld.000webhostapp.com/getcategories.php");
            DownloadTask task = new DownloadTask(this);
            task.execute(url);
        }
        catch(Exception e)
        {

        }
    }

    @Override
    public void onDownloadTaskCompleted(String s) {
        try {

            JSONArray array = new JSONArray(s);
            final ArrayList<Category> categories = new ArrayList<>();

            for(int i=0;i<array.length();i++)
            {
                JSONObject object = array.getJSONObject(i);
                int categoryid=object.getInt("categoryid");
                String name = object.getString("name");

                Category category = new Category(categoryid,name);
                categories.add(category);
            }

            CategoryAdapter adapter = new CategoryAdapter(MainActivity.this,categories);
            GridView gridView = findViewById(R.id.gridCategory);
            gridView.setAdapter(adapter);

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Category category = categories.get(i);
                    Intent intent = new Intent(MainActivity.this,ProductListActivity.class);
                    intent.putExtra("categoryid",category.getCategoryid());
                    startActivity(intent);
                }
            });

        }
        catch (Exception e)
        {

        }
    }
}
