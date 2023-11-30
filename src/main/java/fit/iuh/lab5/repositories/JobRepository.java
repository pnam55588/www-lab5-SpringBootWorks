package fit.iuh.lab5.repositories;

import fit.iuh.lab5.models.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobRepository extends JpaRepository<Job, Long> {

    @Query("SELECT j FROM Job j JOIN JobSkill js ON j.id = js.job.id JOIN Skill s ON js.skill.id = s.id WHERE s.skillName = :selectedSkill")
    Page<Job> findAllByJobSkillsSkillSkillName(String selectedSkill, Pageable pageable);
}