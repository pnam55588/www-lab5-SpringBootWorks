package fit.iuh.lab5.repositories;

import fit.iuh.lab5.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}