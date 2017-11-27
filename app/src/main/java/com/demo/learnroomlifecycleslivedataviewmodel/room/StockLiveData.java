package com.demo.learnroomlifecycleslivedataviewmodel.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;

import java.math.BigDecimal;

/**
 * Created by nikunj on 2/10/17.
 */

public class StockLiveData extends LiveData<BigDecimal> {
    private RoomActivity mStockManager;

    private SimplePriceListener mListener = new SimplePriceListener() {
        @Override
        public void onPriceChanged(BigDecimal price) {
            setValue(price);
        }
    };

    public StockLiveData(String symbol) {
        mStockManager = new RoomActivity(symbol);
    }

    @Override
    protected void onActive() {
        mStockManager.requestPriceUpdates(mListener);
    }

    @Override
    protected void onInactive() {
        mStockManager.removeUpdates(mListener);
    }
}