package fit.iuh.lab5.repositories;

import fit.iuh.lab5.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}