package ru.ncideas.magazinof.gwt.exceptions;

public class LoginException extends ServerException {

    public LoginException() {
    }

    public LoginException(String message) {
        super("Login Exception: " + message);
    }
}
