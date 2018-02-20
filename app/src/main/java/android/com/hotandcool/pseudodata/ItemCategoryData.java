package android.com.hotandcool.pseudodata;

import android.com.hotandcool.R;
import android.com.hotandcool.adapter.CategoryItemAdapter;
import android.com.hotandcool.adapter.CategoryListRecyclerViewAdapter;
import android.com.hotandcool.domain.CategoryItem;
import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by khoa1 on 2/18/2018.
 */

public class ItemCategoryData {

    public static ArrayAdapter<CategoryItem> getCategoryItem(Context context, int resource)
    {
        ArrayList<CategoryItem> categoryItemArrayList = new ArrayList<>();
        categoryItemArrayList.add(new CategoryItem(0, "Trà sữa", R.drawable.recipe_3_2));
        categoryItemArrayList.add(new CategoryItem(3, "Sinh tố", R.drawable.sinhto));
        categoryItemArrayList.add(new CategoryItem(1, "Đồ ăn", R.drawable.doan));
        categoryItemArrayList.add(new CategoryItem(2, "Combo tiết kiệm", R.drawable.combo));
        CategoryItemAdapter categoryItemAdapter = new CategoryItemAdapter(context, resource, categoryItemArrayList);

        return  categoryItemAdapter;
    }


    public static CategoryListRecyclerViewAdapter getCategoryItem1(Context context, int resource)
    {
        ArrayList<CategoryItem> categoryItemArrayList = new ArrayList<>();
        categoryItemArrayList.add(new CategoryItem(0, "TS truyền thống", R.drawable.ts8));
        categoryItemArrayList.add(new CategoryItem(3, "TS Kem", R.drawable.ts6));
        categoryItemArrayList.add(new CategoryItem(1, "TS Trân Châu", R.drawable.ts9));
        categoryItemArrayList.add(new CategoryItem(4, "TS Hoa Quả", R.drawable.ts2));
        categoryItemArrayList.add(new CategoryItem(5, "TS Đặc Biệt", R.drawable.ts5));
        categoryItemArrayList.add(new CategoryItem(6, "TS Topping", R.drawable.ts7));
        categoryItemArrayList.add(new CategoryItem(7, "TS Hồng Trà", R.drawable.ts4));
        categoryItemArrayList.add(new CategoryItem(8, "TS Người lớn", R.drawable.ts1));
        CategoryListRecyclerViewAdapter categoryItemAdapter = new CategoryListRecyclerViewAdapter(context, categoryItemArrayList);

        return  categoryItemAdapter;
    }
}
