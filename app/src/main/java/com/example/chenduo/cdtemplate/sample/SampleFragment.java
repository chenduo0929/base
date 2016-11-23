package com.example.chenduo.cdtemplate.sample;

import android.support.annotation.NonNull;

import com.example.chenduo.cdtemplate.BaseFragment;
import com.example.chenduo.cdtemplate.R;

public class SampleFragment extends BaseFragment implements SampleContract.View {
    private SampleContract.Presenter mPresenter;

    public static SampleFragment newInstance() {
        SampleFragment fragment = new SampleFragment();
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();

        mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();

        mPresenter.unsubscribe();
    }

    @Override
    public void setPresenter(@NonNull SampleContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_sample;
    }

}
