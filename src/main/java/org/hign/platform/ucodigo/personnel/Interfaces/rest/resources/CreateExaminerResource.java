package org.hign.platform.ucodigo.personnel.Interfaces.rest.resources;

import org.hign.platform.ucodigo.personnel.Domain.Model.ValueObject.NationalProviderIdentifier;

/**
 * A record that represents the data required to create an examiner.
 * This resource includes the first name, last name, and National Provider Identifier of the examiner.
 */
public record CreateExaminerResource(
        String firstName,
        String lastName,
        NationalProviderIdentifier nationalProviderIdentifier
) {}
