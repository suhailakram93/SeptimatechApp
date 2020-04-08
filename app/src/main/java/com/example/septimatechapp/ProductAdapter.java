package com.example.septimatechapp;


import android.content.Context;


import android.view.LayoutInflater;


import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;

import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.List;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyHolder> {

    private Context context;
    private List<ModelProducts> postList;

    ProductAdapter(Context context, List<ModelProducts> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.productstemplate, viewGroup, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder, final int i) {

        //String pId=postList.get(i).getpId();
        String pName = postList.get(i).getpName();
        final String pImage = postList.get(i).getpImage();

        myHolder.utext.setText(pName);

        try {
            Picasso.with(context).load(pImage).into(myHolder.uimage);
        } catch (Exception e) {

        }
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        ImageView uimage;
        TextView utext;


        public MyHolder(@NonNull View itemView) {
            super(itemView);
            uimage = itemView.findViewById(R.id.productimg);
            utext = itemView.findViewById(R.id.producttext);
        }
    }
}
