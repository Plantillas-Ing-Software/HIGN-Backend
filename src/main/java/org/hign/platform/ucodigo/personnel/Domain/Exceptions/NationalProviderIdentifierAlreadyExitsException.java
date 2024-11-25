package org.hign.platform.ucodigo.personnel.Domain.Exceptions;

public class NationalProviderIdentifierAlreadyExitsException extends RuntimeException {

    public NationalProviderIdentifierAlreadyExitsException(String message) {
        super(message);
    }
}
