
package com.example.chenduo.cdtemplate.demo.metro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.HorizontalScrollView;

import com.example.chenduo.cdtemplate.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DemoMetroActivity extends AppCompatActivity {

    @BindView(R.id.metrolayout)
    MetroLayout mMetrolayout;
    @BindView(R.id.horizontalScrollView)
    HorizontalScrollView mHorizontalScrollView;
    @BindView(R.id.metrocursor)
    MetroCursorView mMetrocursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_metro);

        ButterKnife.bind(this);

        init();
    }

    int colors[] = {
            R.color.material_yellow_900,
            R.color.material_teal_900,
            R.color.material_light_green_900,
            R.color.material_red_300
    };
    int types[] = {
            MetroLayout.Normal, MetroLayout.Vertical, MetroLayout.Horizontal
    };

    void init() {
        mMetrolayout.setMetroCursorView(mMetrocursor);

        mHorizontalScrollView.setFadingEdgeLength(50);
        mHorizontalScrollView.setSmoothScrollingEnabled(true);
        mHorizontalScrollView.setFillViewport(true);

        for (int i = 0; i < 10; i++) {
            int r1 = (int) (Math.random() * colors.length);
            int r2 = (int) (Math.random() * types.length);
            int r3 = (int) (Math.random() * 2);
            View v = new View(this);
            v.setBackgroundColor(this.getResources().getColor(colors[r1]));
            mMetrolayout.addItemView(v, types[r2], r3, 20);
        }
    }

}
