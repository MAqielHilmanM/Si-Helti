package com.automosen.si_helti.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

public class BottomNavigationBehaviour extends CoordinatorLayout.Behavior<View> {
    public BottomNavigationBehaviour() {
        super();
    }

    public BottomNavigationBehaviour(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        boolean dependsOn = dependency instanceof FrameLayout;
        return dependsOn;
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        if(dyConsumed > 0){
            hideBottomNavigationView(child);
        }else if (dyConsumed < 0){
            showBottomNavigationView(child);
        }
    }

    private void showBottomNavigationView(View view){
        view.clearAnimation();
        view.animate().translationY(0);
    }

    private void hideBottomNavigationView(View view){
        view.clearAnimation();
        view.animate().translationY(view.getHeight());
    }
}
