package com.bettertogether.app.dialogs;

import android.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import com.bettertogether.app.fragments.UserListFragment;
import com.bettertogether.app.R;

import db.RewardType;



public class RewardPopup extends PopupView {

    public RewardPopup(UserListFragment userListFragment) {
        super(userListFragment);
    }

    public void whistle(RewardType rewardType) {
        View popup = layoutInflater.inflate(R.layout.reward_popup_layout, null);
        alertBuilder.setView(popup);

        if (rewardType == RewardType.CAKE) {
            alertBuilder.setTitle("IT IS CAKE TIME!!");
            popup.setBackgroundResource(R.drawable.cake_picture);

        } else {
            alertBuilder.setTitle("IT IS PIZZA TIME!!");
            popup.setBackgroundResource(R.drawable.pizza_and_beer);
        }

        alertBuilder.setPositiveButton(R.string.ok, (dialog, id) -> {
            userListFragment.setPopupIsActiveFalse();
            dialog.dismiss();
        });

        AlertDialog dialog = alertBuilder.create();
        dialog.show();

    }

    public void claimReward(RewardType rewardType) {
        View claim_popup = layoutInflater.inflate(R.layout.claim_reward_layout, null);
        alertBuilder.setView(claim_popup);

        alertBuilder.setMessage("Do you want to claim a " + rewardType.toString() + " event?");

        alertBuilder.setPositiveButton(R.string.yes, (dialog, id) -> {
            userListFragment.useReward(rewardType);

            Toast confirmMsg = Toast.makeText(userListFragment.getContext(), "You have claimed " + rewardType.toString(), Toast.LENGTH_SHORT);
            confirmMsg.show();
            dialog.dismiss();
        });

        alertBuilder.setNegativeButton(R.string.cancel, (dialog, id) -> {
            dialog.dismiss();
        });

        AlertDialog dialog = alertBuilder.create();
        dialog.show();
    }

}
