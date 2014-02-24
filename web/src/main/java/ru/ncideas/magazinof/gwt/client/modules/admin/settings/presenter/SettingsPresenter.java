package ru.ncideas.magazinof.gwt.client.modules.admin.settings.presenter;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import ru.ncideas.magazinof.gwt.client.modules.admin.settings.SettingsEventBus;
import ru.ncideas.magazinof.gwt.client.modules.admin.settings.view.SettingsView;
import ru.ncideas.magazinof.gwt.client.modules.base.interfaces.BaseViewIntf;
import ru.ncideas.magazinof.gwt.client.services.RpcAdminModuleServiceAsync;

import javax.inject.Inject;

@Presenter(view = SettingsView.class)
public class SettingsPresenter extends BasePresenter<SettingsPresenter.ISettingsView, SettingsEventBus> {

    @Inject
    RpcAdminModuleServiceAsync service;

    public interface ISettingsView extends BaseViewIntf {

    }

    @Override
    public void bind() {
    }

    public void onStart() {
        loadSettings();
    }

    public void onGoToSettings() {

    }

    public void loadSettings() {
    }

}
