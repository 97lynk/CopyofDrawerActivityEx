package android.com.hotandcool.fragment;

import android.com.hotandcool.R;
import android.com.hotandcool.adapter.Bill1Adapter;
import android.com.hotandcool.domain.Bill;
import android.com.hotandcool.pseudodata.ItemInListData;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class HistoryFragment extends Fragment {


    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        ArrayList<Bill> bills = new ArrayList<>();
        bills.add(new Bill("10:30 ngày 23/02/2018", 179000.0, "1 Võ Văn Ngân, TĐ, TPHCM", R.drawable.history1, Bill.STATUS.DANG_VC));
        bills.add(new Bill("16:00 ngày 23/02/2018", 205000.0, "1 Đặng Văn Bi, TĐ, TPHCM", R.drawable.history3, Bill.STATUS.DANG_XL));
        bills.add(new Bill("16:00 ngày 23/02/2018", 205000.0, "1 Đặng Văn Bi, TĐ, TPHCM", R.drawable.history3, Bill.STATUS.DANG_XL));
        bills.add(new Bill("16:00 ngày 23/02/2018", 205000.0, "1 Đặng Văn Bi, TĐ, TPHCM", R.drawable.history3, Bill.STATUS.DANG_XL));
        bills.add(new Bill("16:00 ngày 23/02/2018", 205000.0, "1 Đặng Văn Bi, TĐ, TPHCM", R.drawable.history3, Bill.STATUS.DANG_XL));
        bills.add(new Bill("16:00 ngày 23/02/2018", 205000.0, "1 Đặng Văn Bi, TĐ, TPHCM", R.drawable.history3, Bill.STATUS.DANG_XL));
        bills.add(new Bill("16:00 ngày 23/02/2018", 205000.0, "1 Đặng Văn Bi, TĐ, TPHCM", R.drawable.history3, Bill.STATUS.DANG_XL));
        bills.add(new Bill("16:00 ngày 23/02/2018", 205000.0, "1 Đặng Văn Bi, TĐ, TPHCM", R.drawable.history3, Bill.STATUS.DANG_XL));
        bills.add(new Bill("16:00 ngày 23/02/2018", 205000.0, "1 Đặng Văn Bi, TĐ, TPHCM", R.drawable.history3, Bill.STATUS.DANG_XL));
        bills.add(new Bill("16:00 ngày 23/02/2018", 205000.0, "1 Đặng Văn Bi, TĐ, TPHCM", R.drawable.history3, Bill.STATUS.DANG_XL));
        recyclerView.setAdapter(new Bill1Adapter(getContext(),bills));


        Toolbar toolbar = (Toolbar) view.findViewById(R.id.tb_Bill);
        final AppCompatActivity activity = ((AppCompatActivity) getActivity());
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
        return view;
    }


}
