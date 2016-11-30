
package com.example.chenduo.cdtemplate.demo.supportDesign;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.chenduo.cdtemplate.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DemoSupportDesignActivity extends AppCompatActivity {

    @BindView(R.id.contentList)
    RecyclerView mContentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        ButterKnife.bind(this);

        init();
    }

    void init() {
        mContentList.setLayoutManager(new LinearLayoutManager(this));
        mContentList.setAdapter(new AdapterDemoSupportDesignList(this));
    }

    int getLayoutResourceId() {
        return R.layout.demo_support_design;
    }

    @OnClick({
            R.id.fab
    })
    public void onClick(View view) {
        if (view instanceof ImageView) {
            Drawable d = ((ImageView) view).getDrawable();
            if (d instanceof Animatable) {
                ((Animatable) d).start();
            }
        }
        // 提示条，Toast的延伸版
        Snackbar.make(view, "FAB", Snackbar.LENGTH_SHORT).show();
    }

}