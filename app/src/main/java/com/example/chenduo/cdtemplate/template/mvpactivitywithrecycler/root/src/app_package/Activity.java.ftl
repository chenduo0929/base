package ${packageName};

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ${activityName} extends BaseActivity {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.${activityLayoutName};
    }

    @Override
    protected void init() {
        initContent();
    }

    private void initContent() {
        ${fragmentName} contentFragment =
            (${fragmentName}) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (contentFragment == null) {
            // Create the fragment
            contentFragment = ${fragmentName}.newInstance();
            ActivityUtils.addFragmentToActivity(
                getSupportFragmentManager(), contentFragment, R.id.contentFrame);
        }

        new ${presenterName}(contentFragment);
    }

}
