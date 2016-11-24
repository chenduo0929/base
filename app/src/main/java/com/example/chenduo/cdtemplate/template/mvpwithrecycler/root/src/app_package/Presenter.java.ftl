package ${packageName};

public class ${presenterName} implements ${contractName}.Presenter {

    ${contractName}.View mView;

    public ${presenterName}(${contractName}.View view) {
        mView = view;
        view.setPresenter(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

}