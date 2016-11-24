
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
        SampleFragment sampleFragment = (SampleFragment) getSupportFragmentManager()
                .findFragmentById(R.id.contentFrame);
        if (sampleFragment == null) {
            // Create the fragment
            sampleFragment = SampleFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), sampleFragment, R.id.contentFrame);
        }

        new SamplePresenter(sampleFragment);
    }

}
