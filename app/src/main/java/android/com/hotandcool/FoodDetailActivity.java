package android.com.hotandcool;

import android.com.hotandcool.pseudodata.ItemInListData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class FoodDetailActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMoreFood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        recyclerViewMoreFood = (RecyclerView) findViewById(R.id.recyclerViewMoreFood);
        RecyclerView.LayoutManager verticalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewMoreFood.setLayoutManager(verticalLayoutManager);
        recyclerViewMoreFood.setAdapter(ItemInListData.getItems1(this, R.layout.item_in_list));

    }
}
