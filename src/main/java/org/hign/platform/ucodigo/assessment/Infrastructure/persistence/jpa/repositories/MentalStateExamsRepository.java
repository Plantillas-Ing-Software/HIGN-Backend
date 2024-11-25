package org.hign.platform.ucodigo.assessment.Infrastructure.persistence.jpa.repositories;


import org.hign.platform.ucodigo.assessment.Domain.Model.Aggregate.MentalStateExams;
import org.hign.platform.ucodigo.personnel.Domain.Model.ValueObject.NationalProviderIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing mental state exam entities.
 * Provides database access methods for operations such as checking the existence of exams by examiner.
 */
@Repository
public interface MentalStateExamsRepository extends JpaRepository<MentalStateExams, Long> {

    /**
     * Checks if a mental state exam exists for a given examiner's National Provider Identifier (NPI).
     *
     * @param examinerNationalProviderIdentifier the {@link NationalProviderIdentifier} of the examiner.
     * @return true if an exam exists for the provided NPI; false otherwise.
     */
    boolean existsByExaminerNationalProviderIdentifier(NationalProviderIdentifier examinerNationalProviderIdentifier);
}
