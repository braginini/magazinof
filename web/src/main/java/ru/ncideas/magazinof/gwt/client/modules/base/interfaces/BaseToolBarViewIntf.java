package ru.ncideas.magazinof.gwt.client.modules.base.interfaces;

import com.google.gwt.user.client.ui.Button;

/**
 * User: mbragin
 * Date: 07.06.12
 * Time: 16:34
 */
public interface BaseToolBarViewIntf extends BaseViewIntf {

    Button getCancelButton();

    Button getSaveButton();

    Button getDeleteButton();

    Button getAddButton();
}
