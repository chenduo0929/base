
package com.example.chenduo.cdtemplate.demo.transition;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.chenduo.cdtemplate.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
   VectorDrawable 是用来绘制静态图的, xml中使用vector定义，例drawable/faboptions_ic_close.xml
   AnimatedVectorDrawable 顾名思义就是针对 VectorDrawable 来做动画的.在xml中使用animated-vector标签定义，
        需要一个VectorDrawable， 一个objectAnimator或set.
        例drawable/faboptions_ic_close_animatable.xml
   objectAnimator 属性动画，例animator/close_to_overflow.xml
        */

/* android4.4 出现Transition的，更方便的使用Animator，可以对两个场景进行动画过渡,
        如果google没有出Support库支持低版本android，可以查找第三方的开源库，例如TransitionEvery支持 */

/* FabOptions项目可以直接用来实现Demo的完整及扩展效果，使用menu.xml指定按钮元素即可 */

public class DemoTransitionActivity extends AppCompatActivity {

    @BindView(R.id.background)
    View mBackground;
    @BindView(R.id.faboptions_fab)
    FloatingActionButton mFaboptionsFab;
    @BindView(R.id.activity_demo_transition)
    RelativeLayout mActivityDemoTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_transition);

        ButterKnife.bind(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            close();
        }
    }

    boolean isOpen = false;

    @OnClick(R.id.faboptions_fab)
    public void onClick() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (isOpen) {
                close();
            } else {
                open();
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    void open() {
        startButtonAnimatedVector(R.drawable.faboptions_ic_menu_animatable);
        TransitionManager.beginDelayedTransition(mActivityDemoTransition, new ChangeBounds());
        animateBackground(true);
        isOpen = true;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    void close() {
        startButtonAnimatedVector(R.drawable.faboptions_ic_close_animatable);
        TransitionManager.beginDelayedTransition(mActivityDemoTransition, new ChangeBounds());
        animateBackground(false);
        isOpen = false;
    }

    private void animateBackground(final boolean isOpen) {
        ViewGroup.LayoutParams backgroundLayoutParams = mBackground.getLayoutParams();
        backgroundLayoutParams.width = isOpen ? 800 : 0;
        mBackground.setLayoutParams(backgroundLayoutParams);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    void startButtonAnimatedVector(int res) {
        AnimatedVectorDrawable drawable = (AnimatedVectorDrawable) getResources()
                .getDrawable(res, null);
        mFaboptionsFab.setImageDrawable(drawable);
        drawable.start();
    }
}
