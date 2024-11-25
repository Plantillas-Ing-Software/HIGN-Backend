package org.hign.platform.ucodigo.personnel.Domain.Model.Command;

import org.hign.platform.ucodigo.personnel.Domain.Model.ValueObject.NationalProviderIdentifier;

/**
 * A record that encapsulates the data required to create a new examiner.
 * This command contains the personal details of the examiner, including the first name, last name,
 * and the National Provider Identifier associated with the examiner.
 */
public record CreateExaminerCommand(
        String firstName,
        String lastName,
        NationalProviderIdentifier nationalProviderIdentifier
) {}
