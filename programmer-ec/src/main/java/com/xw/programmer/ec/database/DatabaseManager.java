package com.xw.programmer.ec.database;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

/**
 * Created by nazi on
 * date： 2017/12/26
 */

public class DatabaseManager {
    private DaoSession mDaoSeeion = null;
    private UserProfileDao mDao = null;

    private DatabaseManager(){

    }

    public DatabaseManager init(Context context){

        initDao(context);
        return this;
    }

    private static final class Holder {
        private static final DatabaseManager INSTANCE = new DatabaseManager();

    }

    public static DatabaseManager getInstance() {
        return Holder.INSTANCE;
    }


    private void initDao(Context context) {
        final ReleaseOpenHelper helper = new ReleaseOpenHelper(context, "fast_ec.db");
        final Database db = helper.getWritableDb();
        mDaoSeeion = new DaoMaster(db).newSession();
        mDao = mDaoSeeion.getUserProfileDao();
    }

    public final UserProfileDao getDao(){
        return mDao;
    }
}
