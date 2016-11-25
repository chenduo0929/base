
package com.example.chenduo.cdtemplate.sample;

import android.content.Context;

import com.chenduo.dao.UserDao;
import com.example.chenduo.cdtemplate.bean.User;
import com.example.chenduo.cdtemplate.utils.GreenDaoUtils;
import com.example.chenduo.cdtemplate.utils.Once;

import java.util.List;

public class SamplePresenter implements SampleContract.Presenter {

    SampleContract.View mView;
    Context mContext;

    public SamplePresenter(Context ctx, SampleContract.View view) {
        mView = view;
        view.setPresenter(this);

        mContext = ctx;
    }

    @Override
    public void subscribe() {
        loadData();
    }

    @Override
    public void unsubscribe() {
    }

    void loadData() {
        loadDataFromDB();
    }

    void loadDataFromDB() {
        final UserDao dao = GreenDaoUtils.getInstance().getmDaoSession().getUserDao();

        new Once(mContext).call("DB_INIT", new Once.OnceCallback() {
            @Override
            public void onCall() {
                for (int i = 0; i < 5; i++) {
                    User u = new User();
                    u.setName("test" + i);
                    dao.insert(u);
                }
            }
        });

        List<User> list = dao.loadAll();
        mView.updateUserList(list);
    }

}
