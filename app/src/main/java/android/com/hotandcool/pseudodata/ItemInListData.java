package android.com.hotandcool.pseudodata;

import android.com.hotandcool.R;
import android.com.hotandcool.adapter.CategoryItemAdapter;
import android.com.hotandcool.adapter.ItemInListAdapter;
import android.com.hotandcool.domain.CategoryItem;
import android.com.hotandcool.domain.ItemInList;
import android.content.ClipData;
import android.content.Context;
import android.widget.ArrayAdapter;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by khoa1 on 2/18/2018.
 */

public class ItemInListData {

    public static ArrayAdapter<ItemInList> getItems(Context context, int resource)
    {
        ArrayList<ItemInList> itemInListArrayList = new ArrayList<>();
        itemInListArrayList.add(new ItemInList(0, "Trà Sữa Con Gái",  R.drawable.ts1,new BigDecimal(25000.0)));
        itemInListArrayList.add(new ItemInList(1, "Trà Sữa Mùa Xuân", R.drawable.ts2,new BigDecimal(23000.0)));
        itemInListArrayList.add(new ItemInList(2, "Trà Sữa Đào", R.drawable.ts3,new BigDecimal(24000.0)));
        itemInListArrayList.add(new ItemInList(3, "Trà Sữa Mùa Xuân", R.drawable.ts4,new BigDecimal(20000.0)));
        itemInListArrayList.add(new ItemInList(4, "Trà Sữa Alisan", R.drawable.ts5,new BigDecimal(29000.0)));
        itemInListArrayList.add(new ItemInList(5, "Trà Sữa Khoai Môn", R.drawable.ts6,new BigDecimal(27000.0)));
        itemInListArrayList.add(new ItemInList(6, "Trà Sữa Lục Trà", R.drawable.ts8,new BigDecimal(22000.0)));
        ItemInListAdapter itemInListAdapter = new ItemInListAdapter(context, resource, itemInListArrayList);

        return  itemInListAdapter;
    }
}
