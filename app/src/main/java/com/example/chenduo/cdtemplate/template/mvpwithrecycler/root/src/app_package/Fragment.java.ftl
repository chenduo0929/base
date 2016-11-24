package ${packageName};

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;

public class ${fragmentName} extends BaseFragment implements ${contractName}.View {
    @BindView(R.id.contentList)
    RecyclerView mContentList;

    private ${contractName}.Presenter mPresenter;

    public static ${fragmentName} newInstance() {
        ${fragmentName} fragment = new ${fragmentName}();
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();

        mPresenter.subscribe();
    }

    @Override
    public void onPause() {
         super.onPause();

         mPresenter.unsubscribe();
    }

    @Override
    public void setPresenter(@NonNull ${contractName}.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.${contentLayoutName};
    }

    @Override
    protected void init() {
        mContentList.setLayoutManager(new LinearLayoutManager(getContext()));
        mContentList.setAdapter(new ${adapterName}(getContext()));
    }

}
