
package com.example.chenduo.cdtemplate.sample;

import com.example.chenduo.cdtemplate.BaseActivity;
import com.example.chenduo.cdtemplate.R;
import com.example.chenduo.cdtemplate.utils.ActivityUtils;

public class SampleActivity extends BaseActivity {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_sample;
    }

    @Override
    protected void init() {
        initContent();
    }

    protected void initContent() {
        SampleFragment tasksFragment = (SampleFragment) getSupportFragmentManager()
                .findFragmentById(R.id.contentFrame);
        if (tasksFragment == null) {
            // Create the fragment
            tasksFragment = SampleFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), tasksFragment, R.id.contentFrame);
        }
    }

}
