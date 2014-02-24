package ru.ncideas.magazinof.gwt.exceptions;

public class UsernamePasswordNotFoundException extends LoginException {

    public UsernamePasswordNotFoundException() {
    }

    public UsernamePasswordNotFoundException(String message) {
        super("Incorrect username/password");
    }
}
