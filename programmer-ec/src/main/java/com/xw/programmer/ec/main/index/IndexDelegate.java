package com.xw.programmer.ec.main.index;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.joanzapata.iconify.widget.IconTextView;
import com.xw.programmer.ec.R;
import com.xw.programmer.ec.R2;
import com.xw.programmer_nucleus.delegetes.bottom.BottomItemDelegate;
import com.xw.programmer_nucleus.ui.refresh.RefreshHandler;

import butterknife.BindView;

/**
 * Created by nazi on
 * date： 2018/1/4
 * 首页
 */

public class IndexDelegate extends BottomItemDelegate{

    @BindView(R2.id.rv_index)
    RecyclerView mRecyclerView =  null;
    @BindView(R2.id.srl_index)
    SwipeRefreshLayout mRefreshLayout =  null;
    @BindView(R2.id.tb_index)
    Toolbar mToolbar =  null;
    @BindView(R2.id.icon_index_scan)
    IconTextView mIconScan =  null;
    @BindView(R2.id.et_search_view)
    AppCompatEditText mSearchView =  null;

    private RefreshHandler mRefreshHandler = null;


    @Override
    public void onBindview(@Nullable Bundle savedInstanceState,  @NonNull View rootView) {
        mRefreshHandler = RefreshHandler.create(mRefreshLayout,mRecyclerView,new IndexDataConverter());
    }

    //初始化下拉刷新
    private  void initRefreshLayout(){
        mRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_dark
        );
       /* 设置位置，
        true 球球由小变大，回弹的过程由大变小
        120： 起始的高度
        300： 下降终止的高度
        */
        mRefreshLayout.setProgressViewOffset(true,120,300);
    }

    private void initRecyclerView(){
        final GridLayoutManager manager = new GridLayoutManager(getContext(),4);
        mRecyclerView.setLayoutManager(manager);

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initRefreshLayout();
        initRecyclerView();
       mRefreshHandler.firstPage("index.php");
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

}
