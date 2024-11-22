package org.hign.platform.ucodigo.personnel.Domain.Model.ValueObject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Getter
@Embeddable
public class NationalProviderIdentifier {

    @Column(name = "national_provider_identifier", nullable = false, unique = true)
    private String value;

    protected NationalProviderIdentifier() {
        // Required by JPA
    }

    private NationalProviderIdentifier(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("NationalProviderIdentifier must not be null or empty.");
        }

        try {
            UUID.fromString(value); // Validate if the string is a valid UUID
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("NationalProviderIdentifier must be a valid UUID.", ex);
        }

        this.value = value;
    }

    public static NationalProviderIdentifier from(String value) {
        return new NationalProviderIdentifier(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NationalProviderIdentifier that = (NationalProviderIdentifier) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }
}