package android.com.hotandcool.adapter;

import android.app.AlertDialog;
import android.com.hotandcool.R;
import android.com.hotandcool.domain.Address;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 97lynk on 22/02/2018.
 */

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.AddressHolder> {
    private Context context;
    private List<Address> addressList;


    public AddressAdapter(Context context, List<Address> addressList) {
        this.context = context;
        this.addressList = addressList;
    }

    @Override
    public AddressHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_in_address, parent, false);

        return new AddressHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return addressList.size();
    }

    @Override
    public void onBindViewHolder(final AddressHolder holder, int position) {
        final Address address = addressList.get(position);
        holder.txtAName.setText(address.getName());
        holder.txtAAddress.setText(String.format("%s, Phường/Xã %s, Quận/Huyện %s, TP/Tỉnh %s",
                address.getAddress(), address.getWard(), address.getDistrict(), address.getCity()));
        holder.txtAPhone.setText(address.getPhone());


        holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                //creating a popup menu
                PopupMenu popup = new PopupMenu(context, holder.more);
                //inflating menu from xml resource
                popup.inflate(R.menu.pop_address);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.editAddress:
                                Toast.makeText(context, "Sửa địa chỉ", Toast.LENGTH_LONG).show();
                                break;
                            case R.id.delAddress:
                                showDialog(address, view);
                                Toast.makeText(context, "Xóa địa chỉ", Toast.LENGTH_LONG).show();
                                break;
                        }
                        return false;
                    }
                });
                //displaying the popup
                popup.show();

            }
        });
    }

    public void showDialog(final Address address, final View view) {
        final DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        addressList.remove(address);
                        notifyDataSetChanged();

//                        Snackbar.make(rootView, "Đã xóa địa chỉ", Snackbar.LENGTH_LONG)
//                                .setAction("HOÀN TÁC", new View.OnClickListener() {
//                                    @Override
//                                    public void onClick(View v) {
//                                        addressList.add(address);
//                                        notifyDataSetChanged();
//                                    }
//                                })
//                                .show();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        dialog.cancel();
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Xóa địa chỉ này?").setPositiveButton("Đồng ý", dialogClickListener)
                .setNegativeButton("Hủy", dialogClickListener).show();
    }

    class AddressHolder extends RecyclerView.ViewHolder {

        TextView txtAName;
        TextView txtAAddress;
        TextView txtAPhone;
        ImageButton more;

        public AddressHolder(View itemView) {
            super(itemView);

            txtAName = itemView.findViewById(R.id.txtAName);
            txtAAddress = itemView.findViewById(R.id.txtAAddess);
            txtAPhone = itemView.findViewById(R.id.txtAPhone);
            more = itemView.findViewById(R.id.more);
        }
    }
}
