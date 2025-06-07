package com.example.lab_sed01;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view, context, productList);
    }


    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.txtProductName.setText(product.getName());

        String url = "https://i.imgur.com/tGbaZCY.jpg";
        Picasso.get()
                .load(url)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.imgProduct);
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgProduct;
        TextView txtProductName;
        Context context;
        List<Product> productList;

        public ProductViewHolder(@NonNull View itemView, Context context, List<Product> productList) {
            super(itemView);
            this.context = context;
            this.productList = productList;

            imgProduct = itemView.findViewById(R.id.imgProduct);
            txtProductName = itemView.findViewById(R.id.txtProductName);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Product clickedProduct = productList.get(position);

            Intent intent = new Intent(context, ProductDetailActivity.class);
            intent.putExtra("productName", clickedProduct.getName());
            context.startActivity(intent);
        }
    }

}
