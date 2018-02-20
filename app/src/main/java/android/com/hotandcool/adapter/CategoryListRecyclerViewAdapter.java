package android.com.hotandcool.adapter;

import android.com.hotandcool.FoodDetailActivity;
import android.com.hotandcool.R;
import android.com.hotandcool.domain.CategoryItem;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by khoa1 on 2/20/2018.
 */

public class CategoryListRecyclerViewAdapter extends RecyclerView.Adapter<CategoryListRecyclerViewAdapter.ViewHolder> {

    private ArrayList<CategoryItem> categoryItemArrayList;
    private Context context;

    // data is passed into the constructor
    public CategoryListRecyclerViewAdapter(Context context, ArrayList<CategoryItem> objects) {
        this.categoryItemArrayList = objects;
        this.context = context;
    }



    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category_explore, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CategoryItem categoryItem = categoryItemArrayList.get(position);
        holder.img_category.setImageResource(categoryItem.getImage());
        holder.tvCategory.setText(categoryItem.getName());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return categoryItemArrayList.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvCategory;
        ImageView img_category;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCategory = (TextView) itemView.findViewById(R.id.tvCategory);
            img_category = (ImageView) itemView.findViewById(R.id.img_category);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Clicked in the category", Toast.LENGTH_SHORT).show();
        }
    }


    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}