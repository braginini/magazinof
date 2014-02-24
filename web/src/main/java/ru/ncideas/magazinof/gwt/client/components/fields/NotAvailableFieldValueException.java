package ru.ncideas.magazinof.gwt.client.components.fields;

/**
 * User: mbragin
 * Date: 01.06.12
 * Time: 11:37
 */
public class NotAvailableFieldValueException extends RuntimeException {

    public NotAvailableFieldValueException() {
    }

    public NotAvailableFieldValueException(String message) {
        super(message);
    }

    public NotAvailableFieldValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAvailableFieldValueException(Throwable cause) {
        super(cause);
    }

}
