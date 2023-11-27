package fit.iuh.lab5.frontend.controllers;

import com.neovisionaries.i18n.CountryCode;
import fit.iuh.lab5.models.Address;
import fit.iuh.lab5.models.Candidate;
import fit.iuh.lab5.repositories.AddressRepository;
import fit.iuh.lab5.repositories.CandidateRepository;
import fit.iuh.lab5.services.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequiredArgsConstructor
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("candidates", candidateRepository.findAll());
        return "candidates/candidates";
    }
    @GetMapping("/candidates")
    public String showListPaging(Model model,
                                          @RequestParam("page") Optional<Integer> page,
                                          @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Candidate> candidatePage = candidateService.findAll(currentPage-1,pageSize,"id","desc");
        model.addAttribute("candidatePage",candidatePage);
        int totalPages = candidatePage.getTotalPages();
        if(totalPages >0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages)
                    .boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        return "candidates/candidates-paging";
    }
    @RequestMapping("/candidate-add")
    public String showAddPage(Model model){
//        System.out.println("aaaaaaaaa");
        model.addAttribute("candidate", new Candidate());
        model.addAttribute("address",new Address());
        model.addAttribute("countries", CountryCode.values());
        return "candidates/candidate-add";
    }
    @PostMapping("/add-candidate")
    public String add(@ModelAttribute("candidate") Candidate candidate, @ModelAttribute("address") Address address){
        candidateService.saveAddress(address);
        candidate.setAddress(address);
        candidateService.save(candidate);
        return "redirect:/candidates";
    }
    @RequestMapping("/candidate-edit/{id}")
    public String showEditPage(Model model, @PathVariable("id") String pathId){
        long id = Long.parseLong(pathId);
        Candidate candidate = candidateService.findById(id).orElse(null);
        model.addAttribute("candidate", candidate);
        model.addAttribute("countries", CountryCode.values());
        return "candidates/candidate-edit";
    }
    @PostMapping("/edit-candidate")
    public String edit(@ModelAttribute("candidate") Candidate candidate){
        candidateService.saveAddress(candidate.getAddress());
        candidateService.save(candidate);
        return "redirect:/candidates";
    }
}
