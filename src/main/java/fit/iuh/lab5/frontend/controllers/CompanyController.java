package fit.iuh.lab5.frontend.controllers;

import com.neovisionaries.i18n.CountryCode;
import fit.iuh.lab5.models.Address;
import fit.iuh.lab5.models.Company;
import fit.iuh.lab5.repositories.AddressRepository;

import fit.iuh.lab5.services.CompanyService;
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
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/companies")
    public String showListPaging(Model model,
                                 @RequestParam("page") Optional<Integer> page,
                                 @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Company> paging = companyService.findAll(currentPage-1,pageSize,"id","desc");
        model.addAttribute("paging",paging);
        int totalPages = paging.getTotalPages();
        if(totalPages >0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages)
                    .boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        return "companies/companies-paging";
    }
    @RequestMapping("/company-add")
    public String showAddPage(Model model){
        model.addAttribute("company", new Company());
        model.addAttribute("address",new Address());
        model.addAttribute("countries", CountryCode.values());
        return "companies/company-add";
    }
    @PostMapping("/add-company")
    public String add(@ModelAttribute("company") Company company, @ModelAttribute("address") Address address){
        companyService.saveAddress(address);
        company.setAddress(address);
        companyService.save(company);
        return "redirect:/companies";
    }
    @RequestMapping("/company-edit/{id}")
    public String showEditPage(Model model, @PathVariable("id") String pathId){
        long id = Long.parseLong(pathId);
        Company company = companyService.findById(id).orElse(null);
        model.addAttribute("company", company);
        model.addAttribute("countries", CountryCode.values());
        return "companies/company-edit";
    }
    @PostMapping("/edit-company")
    public String edit(@ModelAttribute("company") Company company){
        companyService.saveAddress(company.getAddress());
        companyService.save(company);
        return "redirect:/companies";
    }
}
