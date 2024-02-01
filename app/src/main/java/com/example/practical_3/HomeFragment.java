package com.example.practical_3;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.practical_3.utils.AlertDialogUtil;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        super(R.layout.fragment_home);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // region show alert dialog
        Button BtnShowAlertDialog = view.findViewById(R.id.BtnShowAlertDialog);
        BtnShowAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("1");
                AlertDialogUtil alertDialogUtil = new AlertDialogUtil(getContext(), "Testing alert dialog");
                System.out.println("2");

                alertDialogUtil.showAlertDialog(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.out.println("this is the onPositiveButtonClickEvent");
                        dialog.dismiss();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.out.println("this is the onNegativeButtonClickEvent");
                        dialog.dismiss();
                    }
                });
            }
        });
    }
}
