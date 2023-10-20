package fit.iuh.lab5.repositories;

import fit.iuh.lab5.models.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}