package org.hign.platform.ucodigo.personnel.Infrastructure.persistence.jpa.repositories;

import org.hign.platform.ucodigo.personnel.Domain.Model.Aggregate.Examiner;
import org.hign.platform.ucodigo.personnel.Domain.Model.ValueObject.NationalProviderIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing and managing {@link Examiner} entities.
 * This interface provides methods for querying the database and checking the existence of examiners
 * based on the National Provider Identifier.
 */
@Repository
public interface ExaminerRepository extends JpaRepository<Examiner, Long> {

    /**
     * Checks if an examiner with the given National Provider Identifier already exists in the database.
     *
     * @param nationalProviderIdentifier the National Provider Identifier to check.
     * @return {@code true} if an examiner with the specified National Provider Identifier exists, otherwise {@code false}.
     */
    boolean existsByNationalProviderIdentifier(NationalProviderIdentifier nationalProviderIdentifier);

}
