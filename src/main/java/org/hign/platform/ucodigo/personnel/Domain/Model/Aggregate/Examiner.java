package org.hign.platform.ucodigo.personnel.Domain.Model.Aggregate;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import org.hign.platform.ucodigo.personnel.Domain.Model.Command.CreateExaminerCommand;
import org.hign.platform.ucodigo.personnel.Domain.Model.ValueObject.NationalProviderIdentifier;
import org.hign.platform.ucodigo.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

/**
 * Represents an examiner in the system.
 * The examiner is associated with a National Provider Identifier and includes personal information such as
 * first name, last name, and the national provider identifier.
 */
@Getter
@Entity
public class Examiner extends AuditableAbstractAggregateRoot<Examiner> {

    private String firstName;

    private String lastName;

    @Embedded
    private NationalProviderIdentifier nationalProviderIdentifier;


    protected Examiner() {}

    /**
     * Constructor to create an Examiner based on the CreateExaminerCommand.
     *
     * @param command The command containing the details for creating an Examiner.
     * @throws IllegalArgumentException if any required field is invalid or null.
     */
    public Examiner(CreateExaminerCommand command){
        this.firstName = command.firstName();
        this.lastName = command.lastName();
        this.nationalProviderIdentifier = command.nationalProviderIdentifier();
    }
}