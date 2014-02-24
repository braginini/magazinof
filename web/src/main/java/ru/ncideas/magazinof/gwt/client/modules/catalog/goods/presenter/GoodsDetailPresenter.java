package ru.ncideas.magazinof.gwt.client.modules.catalog.goods.presenter;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import ru.ncideas.magazinof.gwt.client.components.fields.impl.CustomListBox;
import ru.ncideas.magazinof.gwt.client.components.fields.impl.CustomTextBox;
import ru.ncideas.magazinof.gwt.client.dto.GoodDto;
import ru.ncideas.magazinof.gwt.client.dto.MeasureDto;
import ru.ncideas.magazinof.gwt.client.modules.base.interfaces.BaseViewIntf;
import ru.ncideas.magazinof.gwt.client.modules.catalog.goods.GoodsEventBus;
import ru.ncideas.magazinof.gwt.client.modules.catalog.goods.view.GoodsDetailView;
import ru.ncideas.magazinof.gwt.client.registry.Registry;
import ru.ncideas.magazinof.gwt.client.services.RpcGoodsModuleServiceAsync;

import javax.inject.Inject;
import java.util.List;

/**
 * @author: mbragin
 * Date: 07.06.12
 * Time: 16:56
 */
@Presenter(view = GoodsDetailView.class)
public class GoodsDetailPresenter extends BasePresenter<GoodsDetailPresenter.IGoodsDetailView, GoodsEventBus> {

    public interface IGoodsDetailView extends BaseViewIntf {

        CustomTextBox getName();

        CustomTextBox getArticle();

        CustomTextBox getDescription();

        CustomListBox getMeasure();
    }

    private GoodDto goodDto;
    private boolean areChangesMade = false;

    @Inject
    RpcGoodsModuleServiceAsync service;

    public void onStart() {
    }

    @Override
    public void bind() {
        view.getName().addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                areChangesMade = true;
            }
        });

        view.getArticle().addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                areChangesMade = true;
            }
        });

        view.getMeasure().addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                areChangesMade = true;
            }
        });

        view.getDescription().addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                areChangesMade = true;
            }
        });
    }

    public void onClickGood(GoodDto goodDto) {
        eventBus.changeMainPanel(view.getViewWidget());
        service.findGoodById(goodDto.getId(), new AsyncCallback<GoodDto>() {
            @Override
            public void onFailure(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onSuccess(GoodDto goodDto) {
                fillForm(goodDto);
            }
        });

    }

    public void onAddButtonClick() {
        eventBus.changeMainPanel(view.getViewWidget());
        fillForm(new GoodDto());
    }

    private void fillForm(GoodDto goodDto) {
        this.goodDto = goodDto;
        view.getName().setValue(goodDto.getName() != null ? goodDto.getName() : "");
        view.getArticle().setValue(goodDto.getArticle() != null ? goodDto.getArticle() : "");
        view.getDescription().setValue(goodDto.getDescription() != null ? goodDto.getDescription() : "");
        fillMeasures();
        if (goodDto.getMeasure() != null) {
            view.getMeasure().setValue(goodDto.getMeasure().getName() != null ? goodDto.getMeasure().getName() : "");
            view.getMeasure().setIdValue(goodDto.getMeasure().getId() != null ? goodDto.getMeasure().getId() : -1l);
        }
    }

    private void fillMeasures() {
        view.getMeasure().clearList();
        List<MeasureDto> measures = Registry.get("measures");
        for (MeasureDto m : measures) {
            view.getMeasure().addItem(m.getName());
        }
    }

    public void onSaveButtonClick() {
        if (areChangesMade) {
            GoodDto newGood = fillBean();
            saveGood(newGood);
        }
    }

    private void saveGood(final GoodDto newGood) {
        //add new or update existing good
        service.saveGood(newGood, new AsyncCallback<Long>() {
            @Override
            public void onFailure(Throwable throwable) {
            }

            @Override
            public void onSuccess(Long id) {
                if (id != null) {
                    actAfterSavingToDb(id, newGood);
                } else {
                    //TODO show error messages
                }
            }
        });
    }

    private void actAfterSavingToDb(Long id, GoodDto newGood) {
        if (goodWasUpdated(id)) {
            eventBus.goodUpdated(newGood);
        } else {
            newGood.setId(id);
            eventBus.newGoodAdded(newGood);
        }
    }

    //decides if good was updated (true) or added  (false)
    private boolean goodWasUpdated(Long id) {
        boolean result = false;
        if (this.goodDto.getId() == id) {
            result = true;
        }
        return result;
    }

    private GoodDto fillBean() {
        GoodDto newGood = new GoodDto();
        //TODO get accountId from user
        newGood.setId(this.goodDto.getId());
        newGood.setAccountId(2l);
        newGood.setArticle(view.getArticle().getValue().toString());
        newGood.setDescription(view.getDescription().getValue().toString());
        newGood.setMeasureId(view.getMeasure().getIdValue());
        newGood.setName(view.getName().getValue().toString());
        //TODO get organizationId from user
        newGood.setOrganizationId(2l);

        return newGood;
    }

    public void onCancelButtonClick() {
        //TODO check changes
    }

    public void onNewGoodAdded(GoodDto newGood) {
        this.goodDto = newGood;
        //TODO show success dialog
    }

    public void onGoodUpdated(GoodDto newGood) {
        this.goodDto = newGood;
        //TODO show success dialog
    }
}
