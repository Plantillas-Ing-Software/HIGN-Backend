package org.hign.platform.ucodigo.assessment.Infrastructure.persistence.jpa.repositories;


import org.hign.platform.ucodigo.assessment.Domain.Model.Aggregate.MentalStateExams;
import org.hign.platform.ucodigo.personnel.Domain.Model.ValueObject.NationalProviderIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentalStateExamsRepository extends JpaRepository<MentalStateExams, Long> {

    boolean existsByExaminerNationalProviderIdentifier(NationalProviderIdentifier examinerNationalProviderIdentifier);

}
