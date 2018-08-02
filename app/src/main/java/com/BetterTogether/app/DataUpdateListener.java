package com.BetterTogether.app;

public interface DataUpdateListener {

    void tokenReceived(String token);

    void responseError(int code, String message);

    void updateGrid();

    void updateStatus();
}
