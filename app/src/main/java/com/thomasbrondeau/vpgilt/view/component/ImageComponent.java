package com.thomasbrondeau.vpgilt.view.component;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by THOMASBRONDEAU_Steven on 18/04/2018.
 * Use this wrapper class if one day we have to switch to another image library (Picasso, Fresco, etc.)
 */

public class ImageComponent {

    public static void loadImage(final Context ctx, String url, ImageView imageView, boolean roundedCorners){
        final int RADIUS = 10;

        RequestOptions options = new RequestOptions()
                .placeholder(new ColorDrawable(Color.LTGRAY));

        if (roundedCorners) {
            options = options.transforms(new CenterCrop(), new RoundedCorners(RADIUS));
        }

        Glide.with(ctx)
                .load(url)
                .apply(options)
                .into(imageView);
    }
}
