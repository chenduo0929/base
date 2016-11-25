
package com.example.chenduo.cdtemplate.utils;

import android.database.sqlite.SQLiteDatabase;

import com.chenduo.dao.DaoMaster;
import com.chenduo.dao.DaoSession;
import com.example.chenduo.cdtemplate.MyApplication;

/**
 * Created by chenduo on 16-11-25.
 */
public class GreenDaoUtils {

    private static GreenDaoUtils ourInstance = new GreenDaoUtils();

    public static GreenDaoUtils getInstance() {
        return ourInstance;
    }

    private GreenDaoUtils() {
    }

    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private static final String KEY_DB_NAME = "db-cd-test";

    private void initGreenDao() {
        mHelper = new DaoMaster.DevOpenHelper(MyApplication.getInstance(), KEY_DB_NAME, null);
        db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getmDaoSession() {
        if (mDaoMaster == null) {
            initGreenDao();
        }
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        if (db == null) {
            initGreenDao();
        }
        return db;
    }

}
