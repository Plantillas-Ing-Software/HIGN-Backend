package org.hign.platform.ucodigo.personnel.Domain.Exceptions;

/**
 * Exception thrown when an attempt is made to create an examiner with a National Provider Identifier
 * that already exists in the system.
 */
public class NationalProviderIdentifierAlreadyExitsException extends RuntimeException {

    /**
     * Constructs a new {@link NationalProviderIdentifierAlreadyExitsException} with the specified detail message.
     *
     * @param message the detail message explaining the cause of the exception.
     */
    public NationalProviderIdentifierAlreadyExitsException(String message) {
        super(message);
    }
}