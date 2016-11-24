
package com.example.chenduo.cdtemplate.sample;

public class SamplePresenter implements SampleContract.Presenter {

    SampleContract.View mView;

    public SamplePresenter(SampleContract.View view) {
        mView = view;
        view.setPresenter(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

}
