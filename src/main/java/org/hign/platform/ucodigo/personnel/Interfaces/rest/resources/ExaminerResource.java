package org.hign.platform.ucodigo.personnel.Interfaces.rest.resources;

import org.hign.platform.ucodigo.personnel.Domain.Model.ValueObject.NationalProviderIdentifier;

/**
 * A record that represents the details of an examiner.
 * This resource includes the unique identifier, first name, last name,
 * and National Provider Identifier of the examiner.
 */
public record ExaminerResource(
        Long id,
        String firstName,
        String lastName,
        NationalProviderIdentifier nationalProviderIdentifier
) {}
