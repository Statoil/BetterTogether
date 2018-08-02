package com.BetterTogether.app.Dialogs;

import android.app.AlertDialog;
import com.BetterTogether.app.Fragments.UserListFragment;

public class ErrorPopup extends PopupView {
    public ErrorPopup(UserListFragment userListFragment) {
        super(userListFragment);
    }

    public void setUpErrorPopup(String message){
        alertBuilder
                .setMessage(message)
                .setTitle("ERROR");

        alertBuilder.setPositiveButton("OK", (dialogInterface, i) -> {}
                );

        AlertDialog dialog = alertBuilder.create();
        dialog.show();
    }
}
