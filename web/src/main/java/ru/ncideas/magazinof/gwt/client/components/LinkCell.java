package ru.ncideas.magazinof.gwt.client.components;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;

/**
 * User: mbragin
 * Date: 29.03.12
 * Time: 10:35
 */
public class LinkCell extends AbstractCell<String> {

    interface Templates extends SafeHtmlTemplates {
        /**
         * The template for this Cell, which includes styles and a value.
         *
         * @param styles the styles to include in the style attribute of the div
         * @param value  the safe value. Since the value type is {@link com.google.gwt.safehtml.shared.SafeHtml},
         *               it will not be escaped before including it in the template.
         *               Alternatively, you could make the value type String, in which
         *               case the value would be escaped.
         * @return a {@link com.google.gwt.safehtml.shared.SafeHtml} instance
         */
        @Template("<div class=\"mf-hyperlink\">{0}</div>")
        SafeHtml cell(SafeHtml value);
    }

    private static Templates templates = GWT.create(Templates.class);

    @Override
    public void render(Context context, String s, SafeHtmlBuilder safeHtmlBuilder) {
        if (s != null) {
            SafeHtml safeValue = SafeHtmlUtils.fromString(s);
            SafeHtml rendered = templates.cell(safeValue);
            safeHtmlBuilder.append(rendered);
        }
    }
}
