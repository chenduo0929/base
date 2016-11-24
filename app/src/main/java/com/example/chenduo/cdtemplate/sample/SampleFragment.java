
package com.example.chenduo.cdtemplate.sample;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.chenduo.cdtemplate.BaseFragment;
import com.example.chenduo.cdtemplate.R;

import butterknife.BindView;

public class SampleFragment extends BaseFragment implements SampleContract.View {
    @BindView(R.id.contentList)
    RecyclerView mContentList;

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

    @Override
    protected void init() {
        mContentList.setLayoutManager(new LinearLayoutManager(getContext()));
        mContentList.setAdapter(new AdapterContentList(getContext()));
    }

}
