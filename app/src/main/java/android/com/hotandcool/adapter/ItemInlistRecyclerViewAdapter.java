package android.com.hotandcool.adapter;

import android.com.hotandcool.CategoryExploreActivity;
import android.com.hotandcool.FoodDetailActivity;
import android.com.hotandcool.R;
import android.com.hotandcool.domain.CategoryItem;
import android.com.hotandcool.domain.ItemInList;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by khoa1 on 2/20/2018.
 */

public class ItemInlistRecyclerViewAdapter extends RecyclerView.Adapter<ItemInlistRecyclerViewAdapter.ViewHolder> {

    private ArrayList<ItemInList> categoryItemArrayList;
    private Context context;

    // data is passed into the constructor
    public ItemInlistRecyclerViewAdapter(Context context, ArrayList<ItemInList> objects) {
        this.categoryItemArrayList = objects;
        this.context = context;
    }



    // inflates the row layout from xml when needed
    @Override
    public ItemInlistRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_in_list, parent, false);
        ItemInlistRecyclerViewAdapter.ViewHolder viewHolder = new ItemInlistRecyclerViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(ItemInlistRecyclerViewAdapter.ViewHolder holder, int position) {
        ItemInList categoryItem = categoryItemArrayList.get(position);
        holder.txt_list_food_name.setText(categoryItem.getName());
        holder.list_img_food.setImageResource(categoryItem.getImage());
        holder.item_food_cost.setText(categoryItem.getPrice().toString());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return categoryItemArrayList.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txt_list_food_name, item_food_cost;
        ImageView list_img_food;

        public ViewHolder(View itemView) {
            super(itemView);
            txt_list_food_name = (TextView) itemView.findViewById(R.id.txt_list_food_name);
            list_img_food = (ImageView) itemView.findViewById(R.id.list_img_food);
            item_food_cost = (TextView) itemView.findViewById(R.id.item_food_cost);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), FoodDetailActivity.class);
            view.getContext().startActivity(intent);
        }
    }


    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}