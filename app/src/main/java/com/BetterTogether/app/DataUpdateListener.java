package com.BetterTogether.app;

import DB.RewardType;

public interface DataUpdateListener {

    void tokenReceived(String token);

    void responseError(int code, String message);

    void updateGrid();

    void updateStatus();

    void useReward(RewardType type);
}
