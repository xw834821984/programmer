package com.xw.programmer_nucleus.ui.banner;

import com.ToxicBakery.viewpager.transforms.DefaultTransformer;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.xw.programmer_nucleus.R;

import java.util.ArrayList;

/**
 * Created by nazi on
 * date： 2018/1/15
 */

public class BannerCreator {

    public static void setDefault(ConvenientBanner<String> convenientBanner,
                                  ArrayList<String> banners,
                                  OnItemClickListener clickListener){
        convenientBanner
                .setPages(new HolderCreator(),banners)
                //设置轮播图的点点
                .setPageIndicator(new int[]{R.drawable.dot_normal,R.drawable.dot_focus})
                //水平居中
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(clickListener)
                .setPageTransformer(new DefaultTransformer())
                .startTurning(3000)
                //循环
                .setCanLoop(true);
    }
}
