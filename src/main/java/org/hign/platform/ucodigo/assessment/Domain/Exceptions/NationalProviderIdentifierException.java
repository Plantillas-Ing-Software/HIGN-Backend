package org.hign.platform.ucodigo.assessment.Domain.Exceptions;

/**
 * Exception thrown when there is an issue related to a National Provider Identifier (NPI).
 * This can occur if an examiner with the specified NPI does not exist, or if there are other
 * business rule violations related to NPIs.
 */
public class NationalProviderIdentifierException extends RuntimeException {

    /**
     * Constructs a new NationalProviderIdentifierException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception.
     */
    public NationalProviderIdentifierException(String message) {
        super(message);
    }
}