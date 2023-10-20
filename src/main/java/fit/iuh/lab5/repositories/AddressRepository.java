package fit.iuh.lab5.repositories;

import fit.iuh.lab5.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}