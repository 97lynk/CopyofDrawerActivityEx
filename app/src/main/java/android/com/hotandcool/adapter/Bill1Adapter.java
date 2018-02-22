package android.com.hotandcool.adapter;

import android.com.hotandcool.R;
import android.com.hotandcool.domain.Bill;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 97lynk on 22/02/2018.
 */

public class Bill1Adapter extends RecyclerView.Adapter<Bill1Adapter.Bill11Holder> {
    private Context context;
    private List<Bill> billList;

    public Bill1Adapter(Context context, List<Bill> billList) {
        this.context = context;
        this.billList = billList;
    }

    @Override
    public Bill11Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_in_history, parent, false);

        return new Bill11Holder(itemView);
    }

    @Override
    public void onBindViewHolder(Bill11Holder holder, int position) {
        final Bill bill = billList.get(position);
        holder.txtDateTime1.setText(bill.getDateTime());
        holder.txtTotal1.setText(bill.getTotal() + "đ");
        holder.txtAddress1.setText(bill.getAddress());
        switch (bill.getStatus()) {
            case DA_GIAO:
                holder.txtStatus1.setText("Đã giao");
                holder.txtStatus1.setTextColor(Color.parseColor("#00C853"));
                break;
            case DANG_VC:
                holder.txtStatus1.setText("Đang vận chuyển");
                holder.txtStatus1.setTextColor(Color.parseColor("#00C853"));
                break;
            case DANG_XL:
                holder.txtStatus1.setText("Đang xử lý");
                holder.txtStatus1.setTextColor(Color.parseColor("#FFC107"));
                break;
        }
        Picasso.with(context)
                .load(bill.getImg())
                .error(R.drawable.placeholder_milktea)
                .placeholder(R.drawable.placeholder_milktea)
                .into(holder.img1);
    }

    @Override
    public int getItemCount() {
        return billList.size();
    }

    class Bill11Holder extends RecyclerView.ViewHolder {
        public ImageView img1;
        public TextView txtDateTime1;
        public TextView txtTotal1;
        public TextView txtAddress1;
        public TextView txtStatus1;


        public Bill11Holder(View itemView) {
            super(itemView);

            img1 = itemView.findViewById(R.id.img1);
            txtDateTime1 = itemView.findViewById(R.id.txtDateTime1);
            txtTotal1 = itemView.findViewById(R.id.txtTotal1);
            txtAddress1 = itemView.findViewById(R.id.txtAddress1);
            txtStatus1 = itemView.findViewById(R.id.txtStatus1);
        }
    }
}
