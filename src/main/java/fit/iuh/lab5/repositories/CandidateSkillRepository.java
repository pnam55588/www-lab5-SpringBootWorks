package fit.iuh.lab5.repositories;

import fit.iuh.lab5.ids.IDCandidateSkill;
import fit.iuh.lab5.models.CandidateSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, IDCandidateSkill> {
}