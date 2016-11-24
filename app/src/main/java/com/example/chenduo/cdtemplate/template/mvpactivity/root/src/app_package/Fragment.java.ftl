package ${packageName};

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ${fragmentName} extends BaseFragment implements ${contractName}.View {
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
    }

}
