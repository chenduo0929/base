package com.example.chenduo.cdtemplate.sample;

import com.example.chenduo.cdtemplate.BasePresenter;
import com.example.chenduo.cdtemplate.BaseView;

public interface SampleContract {

    interface View extends BaseView<Presenter> {
        //do something
    }

    interface Presenter extends BasePresenter {
        //do something
    }

}
