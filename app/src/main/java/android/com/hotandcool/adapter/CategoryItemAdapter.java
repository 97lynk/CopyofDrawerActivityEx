package android.com.hotandcool.adapter;

import android.com.hotandcool.R;
import android.com.hotandcool.domain.CategoryItem;
import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by khoa1 on 2/18/2018.
 */

public class CategoryItemAdapter extends ArrayAdapter {

    private int resource;
    private ArrayList<CategoryItem> categoryItemArrayList;
    private Context context;

    public CategoryItemAdapter(@NonNull Context context, int resource, @NonNull ArrayList<CategoryItem> objects) {
        super(context, resource, objects);

        this.resource = resource;
        this.categoryItemArrayList = objects;
        this.context = context;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        CategoryItemAdapter.ViewHolder viewHolder;
        if (convertView == null) {  //Nếu convertView == null thì tạo một convertView mới bằng cách infalte từ row_listview
            convertView = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);
            //Tạo một viewHolder để lưu các giá view lấy được từ convertView
            viewHolder = new CategoryItemAdapter.ViewHolder();
            viewHolder.tvCategory = (TextView) convertView.findViewById(R.id.tvCategory);
           viewHolder.img_category = (ImageView) convertView.findViewById(R.id.img_category);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CategoryItemAdapter.ViewHolder) convertView.getTag();
        }
        CategoryItem categoryItem = categoryItemArrayList.get(position);


        viewHolder.tvCategory.setText(categoryItem.getName());
        viewHolder.img_category.setImageResource(categoryItem.getImage());
        return convertView;
    }

    public class ViewHolder {
        TextView tvCategory;
        ImageView img_category;
    }

}
