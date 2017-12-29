package com.xw.programmer_nucleus.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import com.xw.programmer_nucleus.R;
import com.xw.programmer_nucleus.delegetes.LatteDelegate;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by nazi on
 * date： 2017/12/5
 * 核心activity
 */

public abstract class ProxyActivitie extends SupportActivity {


        public abstract LatteDelegate setRootDelegate();

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            initContainer(savedInstanceState);
        }

        //初始化视图
        private void initContainer(@Nullable Bundle savedInstanceState) {
            final ContentFrameLayout container = new ContentFrameLayout(this);
            container.setId(R.id.delegate_container);

            setContentView(container);
            if (savedInstanceState == null) {
                loadRootFragment(R.id.delegate_container, setRootDelegate());


            }
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            System.gc();
            System.runFinalization();
        }
    }


