package fit.iuh.lab5.repositories;

import fit.iuh.lab5.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}