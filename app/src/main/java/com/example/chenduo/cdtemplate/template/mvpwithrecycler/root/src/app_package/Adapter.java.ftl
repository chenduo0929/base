package ${packageName};

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ${adapterName} extends RecyclerView.Adapter {

        Context mContext;

        public ${adapterName}(Context ctx) {
            mContext = ctx;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ItemHolder(LayoutInflater.from(mContext).inflate(R.layout.${itemLayoutName}, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        class ItemHolder extends RecyclerView.ViewHolder {

            public ItemHolder(View itemView) {
                super(itemView);
            }
        }

}