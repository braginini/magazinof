package ru.ncideas.magazinof.gwt.exceptions;

public class PasswordNotFoundException extends LoginException {

    public PasswordNotFoundException() {
    }

    public PasswordNotFoundException(String message) {
        super("Incorrect password for \"" + message + "\" user");
    }
}
