
package com.example.chenduo.cdtemplate.sample;

import android.content.Context;

import com.example.chenduo.cdtemplate.bean.GithubUserInfo;
import com.example.chenduo.cdtemplate.bean.User;
import com.example.chenduo.cdtemplate.utils.GreenDaoUtils;
import com.example.chenduo.cdtemplate.utils.L;
import com.example.chenduo.cdtemplate.utils.Once;
import com.example.chenduo.cdtemplate.utils.retrofitutils.RetrofitHelper;

import org.greenrobot.greendao.rx.RxDao;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

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
        // loadDataFromDB();
        loadDataFromNet();
    }

    void loadDataFromNet() {
        RetrofitHelper.INSTANCE.getService(GitHubService.class).getUserInfo("chenduo0929")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<GithubUserInfo>() {
                    @Override
                    public void call(GithubUserInfo githubUserInfo) {
                        User u = new User();
                        u.setName(githubUserInfo.getId() + "");
                        List<User> list = new ArrayList();
                        list.add(u);
                        mView.updateUserList(list);
                    }
                }, new Action1<Throwable>() {
                    // onError()
                    @Override
                    public void call(Throwable throwable) {
                        // Error handling
                        L.e(throwable.getMessage());
                    }
                });
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
