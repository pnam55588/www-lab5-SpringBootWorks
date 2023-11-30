package fit.iuh.lab5.repositories;

import fit.iuh.lab5.ids.IDJobSkill;
import fit.iuh.lab5.models.JobSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSkillRepository extends JpaRepository<JobSkill, IDJobSkill> {

}