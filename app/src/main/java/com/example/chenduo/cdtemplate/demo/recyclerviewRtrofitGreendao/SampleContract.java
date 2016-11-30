package com.example.chenduo.cdtemplate.demo.recyclerviewRtrofitGreendao;

import com.example.chenduo.cdtemplate.BasePresenter;
import com.example.chenduo.cdtemplate.BaseView;
import com.example.chenduo.cdtemplate.bean.User;

import java.util.List;

public interface SampleContract {

    interface View extends BaseView<Presenter> {
        //do something
        void updateUserList(List<User> userList);
    }

    interface Presenter extends BasePresenter {
        //do something
    }

}
