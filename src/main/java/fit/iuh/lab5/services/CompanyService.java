package fit.iuh.lab5.services;

import fit.iuh.lab5.models.Address;
import fit.iuh.lab5.models.Candidate;
import fit.iuh.lab5.models.Company;
import fit.iuh.lab5.repositories.AddressRepository;
import fit.iuh.lab5.repositories.CandidateRepository;
import fit.iuh.lab5.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private AddressRepository addressRepository;

    public Page<Company> findAll(int pageNo, int pageSize, String sortBy, String sortDirection){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection),sortBy);
        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
        return  companyRepository.findAll(pageable);
    };

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Optional<Company> findById(long id) {
        return companyRepository.findById(id);
    }
}
