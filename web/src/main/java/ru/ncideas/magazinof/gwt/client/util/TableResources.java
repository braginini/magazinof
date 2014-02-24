package ru.ncideas.magazinof.gwt.client.util;

import com.google.gwt.user.cellview.client.CellTable;

//created by m.bragin
public interface TableResources extends CellTable.Resources {
    @Source({"CellTableStyle.css"})
    TableStyle cellTableStyle();
  }

  interface TableStyle extends CellTable.Style {
  }