package fit.iuh.lab5.services;

import fit.iuh.lab5.models.Company;
import fit.iuh.lab5.models.Job;
import fit.iuh.lab5.models.Skill;
import fit.iuh.lab5.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobService {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private JobSkillRepository jobSkillRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private CompanyRepository companyRepository;

    public Page<Job> findAll(int pageNo, int pageSize, String sortBy, String sortDirection){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection),sortBy);
        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
        return  jobRepository.findAll(pageable);
    };

    public Job save(Job job) {
        return jobRepository.save(job);
    }

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public Optional<Job> findById(long id) {
        return jobRepository.findById(id);
    }

    public List<Skill> getSkills() {
        return skillRepository.findAll();
    }

    public Page<Job> findAllBySkill(String selectedSkill,int pageNo, int pageSize, String sortBy, String sortDirection){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection),sortBy);
        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
        return  jobRepository.findAllByJobSkillsSkillSkillName(selectedSkill, pageable);
    };
}
