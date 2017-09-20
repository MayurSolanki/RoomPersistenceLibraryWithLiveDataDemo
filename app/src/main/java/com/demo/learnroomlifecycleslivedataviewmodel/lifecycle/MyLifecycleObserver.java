package com.demo.learnroomlifecycleslivedataviewmodel.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by nikunj on 13/9/17.
 */

public class MyLifecycleObserver implements LifecycleObserver {

    private static final String TAG = MyLifecycleObserver.class.getSimpleName();





    public MyLifecycleObserver(LifecycleOwner lifecycleOwner) {
        lifecycleOwner.getLifecycle().addObserver(this);

    }

    public static MyLifecycleObserver bindInto(LifecycleOwner lifecycleOwner){
        return new MyLifecycleObserver(lifecycleOwner);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void callMeOnCreate(){
        Log.d(TAG,"On Create");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void callMeOnStart(){
        Log.d(TAG,"On Start");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void callMeOnResume(){
        Log.d(TAG,"On Resume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void callMeOnPause(){
        Log.d(TAG,"On Pause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void callMeOnStop(){
        Log.d(TAG,"On Stop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void callMeOnDestroy(){
        Log.d(TAG,"On Destroy");
    }
}
