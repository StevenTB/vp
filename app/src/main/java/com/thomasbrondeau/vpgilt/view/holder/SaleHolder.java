package com.thomasbrondeau.vpgilt.view.holder;

import android.content.Context;
import android.os.SystemClock;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.thomasbrondeau.vpgilt.R;
import com.thomasbrondeau.vpgilt.model.entity.Sale;
import com.thomasbrondeau.vpgilt.view.component.ImageComponent;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by THOMASBRONDEAU_Steven on 18/04/2018.
 */

public class SaleHolder extends RecyclerView.ViewHolder {

    private long mLastClick = 0;

    @BindView(R.id.item_main_container)
    ConstraintLayout layout;
    @BindView(R.id.item_sale_image)
    ImageView icon;
    @BindView(R.id.item_sale_title)
    TextView title;

    private OnHolderClickListener holderClickListener;

    public SaleHolder(View itemView, OnHolderClickListener clickListener) {
        super(itemView);
        holderClickListener = clickListener;
        ButterKnife.bind(this, itemView);
    }

    public static int getLayoutId(){
        return R.layout.item_sale;
    }

    public void render(Context context, final int position, final Sale sale) { //TODO remove mock
        ImageComponent.loadImage(context, sale.getImageUrlByDimens(), icon, true);
        title.setText(sale.getSaleName());
        layout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // avoid multiple clicks
                if (SystemClock.elapsedRealtime() - mLastClick < 500) return;

                mLastClick = SystemClock.elapsedRealtime();
                holderClickListener.onClick(position);
            }
        });
    }
}
