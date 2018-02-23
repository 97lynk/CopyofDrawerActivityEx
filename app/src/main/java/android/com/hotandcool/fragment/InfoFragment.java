package android.com.hotandcool.fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.com.hotandcool.R;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.util.Calendar;

import static android.com.hotandcool.R.color.colorAccent;


public class InfoFragment extends Fragment {
    private boolean changeInfo = false;
    private String fName;
    private String lName;
    private String birthDay;
    private String phone;
    private String email;

    public InfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_info, container, false);
        // toolbar setup
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.tb_info);
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
        //
        final Button btnBirthday = view.findViewById(R.id.btnBirthday);
        btnBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                btnBirthday.setText((dayOfMonth) + "/" + (month + 1) + "/" + year);
                            }
                        },
                        calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.setTitle("Thay đổi ngày sinh");
                datePickerDialog.show();
            }
        });
        //btnChangeInfo
        final TextView btnChangeInfo = view.findViewById(R.id.btnChangeInfo);
        //prepare dialog handler
        final DialogInterface.OnClickListener dialogClickPosListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                btnChangeInfo.setText("Thay đổi");
                changeInfo = !changeInfo;

                enableView(view.findViewById(R.id.txtFirstName), changeInfo);
                enableView(view.findViewById(R.id.txtLastName), changeInfo);
                enableView(view.findViewById(R.id.txtSDT), changeInfo);
                enableView(view.findViewById(R.id.txtEmail), changeInfo);
                enableView(btnBirthday, changeInfo);
            }
        };
        final DialogInterface.OnClickListener dialogClickNavListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                btnChangeInfo.setText("Thay đổi");
                changeInfo = !changeInfo;

                setText(view.findViewById(R.id.txtFirstName), fName);
                setText(view.findViewById(R.id.txtLastName), lName);
                setText(view.findViewById(R.id.txtSDT), phone);
                setText(view.findViewById(R.id.txtEmail), email);
                btnBirthday.setText(birthDay);

                enableView(view.findViewById(R.id.txtFirstName), changeInfo);
                enableView(view.findViewById(R.id.txtLastName), changeInfo);
                enableView(view.findViewById(R.id.txtSDT), changeInfo);
                enableView(view.findViewById(R.id.txtEmail), changeInfo);
                enableView(btnBirthday, changeInfo);
            }
        };
        btnChangeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!changeInfo) {
                    changeInfo = true;
                    btnChangeInfo.setText("Lưu");
                    enableView(view.findViewById(R.id.txtFirstName), changeInfo);
                    enableView(view.findViewById(R.id.txtLastName), changeInfo);
                    enableView(view.findViewById(R.id.txtSDT), changeInfo);
                    enableView(view.findViewById(R.id.txtEmail), changeInfo);
                    enableView(btnBirthday, changeInfo);

                    fName = getText(view.findViewById(R.id.txtFirstName));
                    lName = getText(view.findViewById(R.id.txtLastName));
                    phone = getText(view.findViewById(R.id.txtSDT));
                    email = getText(view.findViewById(R.id.txtEmail));
                    birthDay = btnBirthday.getText().toString();
                } else {

                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage("Lưu thay đổi?").setPositiveButton("Đồng ý", dialogClickPosListener)
                            .setNegativeButton("Hủy", dialogClickNavListener).show();
                }

            }
        });
        //btnChangePass
        TextView btnChangePass = view.findViewById(R.id.btnChangePassword);
        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setView(inflater.inflate(R.layout.layout_change_password, null));
                builder.setTitle("Đổi mật khẩu")
                        .setPositiveButton("Lưu", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();
            }
        });


        return view;
    }

    public void enableView(View view, boolean enable) {
        view.setEnabled(enable);

        if (enable) {
            view.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            view.setBackgroundTintList(getContext().getResources()
                    .getColorStateList(R.color.colorAccent));
        } else {
            view.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            view.setBackgroundTintList(getContext().getResources()
                    .getColorStateList(android.R.color.transparent));
        }
    }

    private String getText(View view) {
        return ((EditText) view).getText().toString();
    }

    private void setText(View view, String text) {
        ((EditText) view).setText(text);
    }
}
