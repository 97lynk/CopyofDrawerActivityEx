package android.com.hotandcool.fragment;

import android.com.hotandcool.R;
import android.com.hotandcool.adapter.AddressAdapter;
import android.com.hotandcool.domain.Address;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class AddressFragment extends Fragment {

    public AddressFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_address, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_address);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        ArrayList<Address> address = new ArrayList<>();
        address.add(new Address("Tuấn", "0123456789", "TPHCM",
                "Thủ Đức", "Tam Phú", "1 Tô Ngọc Vân"));
        address.add(new Address("Khoa", "0123456789", "TPHCM",
                "Thủ Đức", "Linh Chiểu", "1 Võ Văn Ngân"));
        address.add(new Address("Nhã", "0123456789", "TPHCM",
                "Thủ Đức", "Linh Chiểu", "1 Võ Văn Ngân"));
        address.add(new Address("Vân", "0123456789", "TPHCM",
                "Thủ Đức", "Linh Chiểu", "1 Võ Văn Ngân"));
        address.add(new Address("Minh", "0123456789", "TPHCM",
                "Thủ Đức", "Linh Chiểu", "1 Võ Văn Ngân"));
        address.add(new Address("Hòa", "0123456789", "TPHCM",
                "Thủ Đức", "Linh Chiểu", "1 Võ Văn Ngân"));
        address.add(new Address("Thông", "0123456789", "TPHCM",
                "Thủ Đức", "Linh Chiểu", "1 Võ Văn Ngân"));
        address.add(new Address("Thảo", "0123456789", "TPHCM",
                "Thủ Đức", "Linh Chiểu", "1 Võ Văn Ngân"));
        recyclerView.setAdapter(new AddressAdapter(getContext(), address));

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.tb_address);
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
