package attri.girish.gadgetworldapp.adapter;

import android.content.Context;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import attri.girish.gadgetworldapp.R;
import attri.girish.gadgetworldapp.model.Image;
import attri.girish.gadgetworldapp.model.Product;

public class ProductAdapter extends ArrayAdapter<Product>
{
    public ProductAdapter(Context context, ArrayList<Product> products)
    {
        super(context,0,products);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_product,parent,false);

        Product product = getItem(position);

        TextView txtProductName = view.findViewById(R.id.txtProductName);
        TextView txtProductPrice = view.findViewById(R.id.txtProductPrice);
        ImageView imageProduct = view.findViewById(R.id.imageProduct);

        txtProductName.setText(product.getName());
        txtProductPrice.setText(product.getPrice()+"");

        String url = product.getImages().get(0).getUrl();

        Log.i("MyApp",url);
        Picasso.get().load(url).into(imageProduct);


        return view;
    }
}
