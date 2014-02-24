package ru.ncideas.magazinof.gwt.client.modules.base.interfaces;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionModel;

import java.util.List;

/**
 * User: mbragin
 * Date: 07.06.12
 * Time: 11:32
 */
public interface BaseListViewIntf<T> extends BaseViewIntf {

    void loadList(List<T> userList);

    CellTable<T> getTable();

    void addToolBar(Widget widget);

    void addValueToList(T value);

    void updateList(T value);

    void removeValueFromList(T value);

    public SelectionModel<T> getSelectionModel();


}
