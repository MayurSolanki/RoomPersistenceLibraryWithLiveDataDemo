package com.demo.learnroomlifecycleslivedataviewmodel;

import android.view.View;

/**
 * Created by nikunj on 18/9/17.
 */

public interface ClickListener {

        public void onClick(View view, int position);
        public void onLongClick(View view,int position);

}
