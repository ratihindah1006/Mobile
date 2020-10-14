package com.example.myflexiblefragment;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class OptionDialogFragment extends DialogFragment implements View.OnClickListener{
    private Button btnChoose, btnClose;
    private RadioGroup rgOptions;
    private RadioButton rbRm, rbJin, rbSg, rbJh, rbJm, rbTae, rbJk;
    private OnOptionDialogListener onOptionDialogListener;
    public OptionDialogFragment() {
        // Required empty public constructor
        }
    public OnOptionDialogListener getOnOptionDialogListener() {
        return onOptionDialogListener;
        }
    public void setOnOptionDialogListener(OnOptionDialogListener onOptionDialogListener) {
        this.onOptionDialogListener = onOptionDialogListener;
        }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_option_dialog, container, false);
        btnChoose = (Button)view.findViewById(R.id.btn_choose);
        btnChoose.setOnClickListener(this);
        btnClose = (Button)view.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(this);
        rgOptions = (RadioGroup)view.findViewById(R.id.rg_options);
        rbRm = (RadioButton)view.findViewById(R.id.rb_Rm);
        rbJin = (RadioButton)view.findViewById(R.id.rb_Jin);
        rbSg = (RadioButton)view.findViewById(R.id.rb_Sg);
        rbJh = (RadioButton)view.findViewById(R.id.rb_Jh);
        rbJm = (RadioButton)view.findViewById(R.id.rb_Jm);
        rbTae = (RadioButton)view.findViewById(R.id.rb_Tae);
        rbJk = (RadioButton)view.findViewById(R.id.rb_Jk);
        return view;
        }
    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_close:
                    getDialog().cancel();
                    break;
                case R.id.btn_choose:
                    int checkedRadioButtonId = rgOptions.getCheckedRadioButtonId();
                    if (checkedRadioButtonId != -1){
                        String coach = null;
                        switch (checkedRadioButtonId){
                            case R.id.rb_Rm:
                                coach = rbRm.getText().toString().trim();
                                break;
                            case R.id.rb_Jin:
                                coach = rbJin.getText().toString().trim();
                                break;
                            case R.id.rb_Sg:
                                coach = rbSg.getText().toString().trim();
                                break;
                            case R.id.rb_Jh:
                                coach = rbJh.getText().toString().trim();
                                break;
                            case R.id.rb_Jm:
                                coach = rbJm.getText().toString().trim();
                                break;
                            case R.id.rb_Tae:
                                coach = rbTae.getText().toString().trim();
                                break;
                            case R.id.rb_Jk:
                                coach = rbJk.getText().toString().trim();
                                break;
                            }
                        getOnOptionDialogListener().onOptionChoosen(coach);
                        getDialog().cancel();
                        }
                    break;
                }
            }
public interface OnOptionDialogListener{
void onOptionChoosen(String text);
}
}
