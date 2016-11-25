
package com.example.chenduo.cdtemplate.sample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chenduo.cdtemplate.R;
import com.example.chenduo.cdtemplate.bean.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chenduo on 16-11-24.
 */

public class AdapterContentList extends RecyclerView.Adapter {

    Context mContext;
    List<User> mUserList;

    public AdapterContentList(Context ctx) {
        mContext = ctx;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(mContext).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        User u = mUserList.get(position);
        if (holder instanceof ItemHolder) {
            ((ItemHolder) holder).mUserName.setText(u.getName());
        }
    }

    public void updateUserList(List<User> list) {
        mUserList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mUserList == null || mUserList.isEmpty()) {
            return 0;
        } else {
            return mUserList.size();
        }
    }

    class ItemHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.userName)
        public TextView mUserName;

        public ItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
