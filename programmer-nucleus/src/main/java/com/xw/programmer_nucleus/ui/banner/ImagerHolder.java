package com.xw.programmer_nucleus.ui.banner;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by nazi on
 * date： 2018/1/15
 */

public class ImagerHolder implements Holder<String>{


    private AppCompatImageView mImageView = null;
    private static final RequestOptions BANNER_OPTIONS = new RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .dontAnimate()
            .centerCrop();

    @Override
    public View createView(Context context) {
        mImageView = new AppCompatImageView(context);
        return mImageView;
    }
    @Override
    public void UpdateUI(Context context, int position, String data) {

        Glide.with(context)
                .load(data)
                .apply(BANNER_OPTIONS)
                .into(mImageView);
    }
}
