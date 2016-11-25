
package com.example.chenduo.cdtemplate.sample;

import android.content.Context;

import com.example.chenduo.cdtemplate.bean.User;
import com.example.chenduo.cdtemplate.utils.GreenDaoUtils;
import com.example.chenduo.cdtemplate.utils.Once;

import org.greenrobot.greendao.rx.RxDao;

import java.util.List;

import rx.functions.Action1;

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
        final RxDao dao = GreenDaoUtils.getInstance().getmDaoSession().getUserDao().rx();

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

        // greenDao结合rxjava
        dao.loadAll().subscribe(new Action1<List<User>>() {
            @Override
            public void call(List<User> list) {
                mView.updateUserList(list);
            }
        });

    }

}
