package android.com.hotandcool;

import android.com.hotandcool.pseudodata.ItemCategoryData;
import android.com.hotandcool.pseudodata.ItemInListData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

public class CategoryExploreActivity extends AppCompatActivity {
    private RecyclerView lvItemCategory;
    private RecyclerView lvItemInList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_explore);

        lvItemCategory = (RecyclerView) findViewById(R.id.listChildCat);


        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(CategoryExploreActivity.this, LinearLayoutManager.HORIZONTAL, false);
        lvItemCategory.setLayoutManager(horizontalLayoutManagaer);

        lvItemCategory.setAdapter(ItemCategoryData.getCategoryItem1(this, R.layout.item_category_explore));
        //lvItemCategory.setAdapter(ItemCategoryData.getCategoryItem1(this, R.layout.category_item));

        lvItemInList = (RecyclerView) findViewById(R.id.lvProduct);
        LinearLayoutManager verticalLayoutManagaer
                = new LinearLayoutManager(CategoryExploreActivity.this, LinearLayoutManager.VERTICAL, false);
        lvItemInList.setLayoutManager(verticalLayoutManagaer);
        lvItemInList.setAdapter(ItemInListData.getItems1(this, R.layout.item_in_list));

    }
}
