package com.automosen.si_helti.utils;

import android.view.View;
import android.widget.ProgressBar;

public class ProgressBarUtils {
    public void showLoadingIndicator(ProgressBar loadingIndicator){
        loadingIndicator.setVisibility(View.VISIBLE);
    }

    public void hideLoadingIndicator(ProgressBar loadingIndicator){
        loadingIndicator.setVisibility(View.GONE);
    }
}
