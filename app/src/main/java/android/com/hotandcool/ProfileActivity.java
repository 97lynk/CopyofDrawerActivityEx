package android.com.hotandcool;

import android.com.hotandcool.fragment.AddressFragment;
import android.com.hotandcool.fragment.HistoryFragment;
import android.com.hotandcool.fragment.InfoFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
//        setSupportActionBar(toolbar);

//        AHBottomNavigation navigation = (AHBottomNavigation) findViewById(R.id.navigation);
//        navigation.setBehaviorTranslationEnabled(true);
//        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
//        layoutParams.setBehavior(new BottomNavigationViewBehavior());
//
//        //CREATE ITEMS
//        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Đơn hàng", R.drawable.ic_list_24dp);
//        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Địa chỉ", R.drawable.ic_location_on_24dp);
//        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Tài khoản", R.drawable.ic_account_circle_24dp);
//
//        //ADD THEM to bar
//        navigation.addItem(item1);
//        navigation.addItem(item2);
//        navigation.addItem(item3);
//
//        //set properties
//        navigation.setAccentColor(getResources().getColor(R.color.colorPrimaryDark));
//        navigation.setInactiveColor(Color.parseColor("#747474"));
//        //set current item
//        navigation.setCurrentItem(0);
//        navigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
//            @Override
//            public boolean onTabSelected(int position, boolean wasSelected) {
////                Toast.makeText(getApplicationContext(), position + " ", Toast.LENGTH_SHORT).show();
//                switch (position) {
//                    case 0:
//                        loadFragment(new HistoryFragment());
//                        return true;
//                    case 1:
//                        loadFragment(new InfoFragment());
//                        return true;
//                    case 2:
//                        loadFragment(new HistoryFragment());
//                        return true;
//                }
//                return false;
//            }
//        });
//        try {
//            loadFragment(new HistoryFragment());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // attaching bottom sheet behaviour - show / show on scroll
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationViewBehavior());

        navigation.setSelectedItemId(R.id.bnv_history);
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_in, R.anim.fade_out, R.anim.fade_in, R.anim.slide_out);

        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.bnv_history:
                    loadFragment(new HistoryFragment());
                    return true;
                case R.id.bnv_info:
                    loadFragment(new InfoFragment());
                    return true;
                case R.id.bnv_address:
                    loadFragment(new AddressFragment());
                    return true;
            }
            return false;
        }
    };
}

