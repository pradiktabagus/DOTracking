package com.wyswyg.dotracking.navigationBar;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toolbar;

import com.wyswyg.dotracking.R;

public class homeFragment extends Fragment implements View.OnClickListener {

    private TextView tvselectDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        tvselectDatabase = view.findViewById(R.id.selectDatabase);
        tvselectDatabase.setOnClickListener(this);

        return view;

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.selectDatabase:
                dialogAlert();
                break;
        }
    }

    private void dialogAlert() {
        Dialog dialogAlert = new Dialog(getContext());
        dialogAlert.setContentView(R.layout.dialog_change_db);
        dialogAlert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogAlert.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        dialogAlert.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialogAlert.show();
    }
}
