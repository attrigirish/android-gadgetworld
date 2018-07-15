package attri.girish.gadgetworldapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import attri.girish.gadgetworldapp.R;
import attri.girish.gadgetworldapp.model.Category;

public class CategoryAdapter extends ArrayAdapter<Category>
{
    public CategoryAdapter(Context context,ArrayList<Category> categories)
    {
        super(context,0,categories);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_category,parent,false);

        Category category = getItem(position);

        ImageView imageCategory = view.findViewById(R.id.imageCategory);
        TextView txtCategoryName = view.findViewById(R.id.txtCategoryName);

        txtCategoryName.setText(category.getName());

        switch(category.getName())
        {
            case "Mobile":
                imageCategory.setImageResource(R.drawable.mobiles);
                break;
            case "Laptops":
                imageCategory.setImageResource(R.drawable.laptops);
                break;
            case "Cameras":
                imageCategory.setImageResource(R.drawable.cameras);
                break;
            case "TV":
                imageCategory.setImageResource(R.drawable.tvs);
                break;
            case "Tablet":
                imageCategory.setImageResource(R.drawable.tablets);
                break;
            case "Speakers":
                imageCategory.setImageResource(R.drawable.speakers);
                break;
        }

        return view;
    }
}
