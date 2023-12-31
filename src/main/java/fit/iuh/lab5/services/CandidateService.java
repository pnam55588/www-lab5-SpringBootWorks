package fit.iuh.lab5.services;

import fit.iuh.lab5.models.Address;
import fit.iuh.lab5.models.Candidate;
import fit.iuh.lab5.repositories.AddressRepository;
import fit.iuh.lab5.repositories.CandidateRepository;
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
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private AddressRepository addressRepository;

    public Page<Candidate> findAll(int pageNo, int pageSize, String sortBy, String sortDirection){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection),sortBy);
        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
        return  candidateRepository.findAll(pageable);
    };

    public Candidate save(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Optional<Candidate> findById(long id) {
        return candidateRepository.findById(id);
    }
}
