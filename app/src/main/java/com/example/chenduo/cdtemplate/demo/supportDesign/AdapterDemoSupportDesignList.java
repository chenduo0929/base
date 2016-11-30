
package com.example.chenduo.cdtemplate.demo.supportDesign;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chenduo.cdtemplate.R;

import butterknife.ButterKnife;

/**
 * Created by chenduo on 16-11-24.
 */

public class AdapterDemoSupportDesignList extends RecyclerView.Adapter {

    Context mContext;

    public AdapterDemoSupportDesignList(Context ctx) {
        mContext = ctx;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(mContext).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    class ItemHolder extends RecyclerView.ViewHolder {

        public ItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
