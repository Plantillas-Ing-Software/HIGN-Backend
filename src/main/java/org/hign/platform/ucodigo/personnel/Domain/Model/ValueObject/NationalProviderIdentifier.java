package org.hign.platform.ucodigo.personnel.Domain.Model.ValueObject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Getter
@Embeddable
public class NationalProviderIdentifier {

    @Column(name = "national_provider_identifier", nullable = false, unique = true)
    private UUID value;

    protected NationalProviderIdentifier() {}

    private NationalProviderIdentifier(UUID value) {
        if (value == null ) {
            throw new IllegalArgumentException("NationalProviderIdentifier must not be null or empty.");
        }

        try {
            UUID.fromString(String.valueOf(value));
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("NationalProviderIdentifier must be a valid UUID.", ex);
        }

        this.value = value;
    }

    public static NationalProviderIdentifier from(UUID value) {
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
}