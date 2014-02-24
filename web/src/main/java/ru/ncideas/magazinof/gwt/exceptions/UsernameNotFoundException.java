package ru.ncideas.magazinof.gwt.exceptions;

public class UsernameNotFoundException extends LoginException {

    public UsernameNotFoundException() {
    }

    public UsernameNotFoundException(String message) {
        super("User with username \"" + message + "\" is not found in system");
    }
}
