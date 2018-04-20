package com.thomasbrondeau.vpgilt.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thomasbrondeau.vpgilt.model.entity.Sale;
import com.thomasbrondeau.vpgilt.view.holder.OnHolderClickListener;
import com.thomasbrondeau.vpgilt.view.holder.OnRecyclerViewClickListener;
import com.thomasbrondeau.vpgilt.view.holder.SaleHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by THOMASBRONDEAU_Steven on 18/04/2018.
 */

public class SaleAdapter extends RecyclerView.Adapter<SaleHolder> implements OnHolderClickListener {

    private Context mContext;
    private OnRecyclerViewClickListener mClickListener;
    private List<Sale> saleList;

    public SaleAdapter(Context context, OnRecyclerViewClickListener mClickListener) {
        this.mContext = context;
        this.mClickListener = mClickListener;
        saleList = new ArrayList<>();
    }

    @Override
    public void onBindViewHolder(SaleHolder holder, int position) {
        Sale sale = saleList.get(position);
        holder.render(mContext, position, sale);
    }

    @Override
    public SaleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(SaleHolder.getLayoutId(), parent, false);
        return new SaleHolder(view, this);
    }

    @Override
    public int getItemCount() {
        return saleList == null ? 0 : saleList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onClick(int position) {
        mClickListener.onRecyclerViewClick(saleList.get(position));
    }

    public void setData(List<Sale> saleList){
        this.saleList = saleList;
        notifyDataSetChanged();
    }
}
