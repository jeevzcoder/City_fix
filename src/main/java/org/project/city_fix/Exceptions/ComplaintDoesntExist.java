package org.project.city_fix.Exceptions;

public class ComplaintDoesntExist extends RuntimeException {
    public ComplaintDoesntExist(String message) {
        super(message);
    }
}
