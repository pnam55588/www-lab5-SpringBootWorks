package fit.iuh.lab5.repositories;

import fit.iuh.lab5.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}