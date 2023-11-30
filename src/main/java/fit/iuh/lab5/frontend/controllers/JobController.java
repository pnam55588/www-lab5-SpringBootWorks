package fit.iuh.lab5.frontend.controllers;


import fit.iuh.lab5.models.Job;

import fit.iuh.lab5.services.JobService;
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
public class JobController {
    @Autowired
    private JobService jobService;


    @GetMapping("/jobs")
    public String showListPaging(Model model,
                                 @RequestParam("page") Optional<Integer> page,
                                 @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Job> paging = jobService.findAll(currentPage-1,pageSize,"id","desc");
        model.addAttribute("paging",paging);
        int totalPages = paging.getTotalPages();
        if(totalPages >0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages)
                    .boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        model.addAttribute("skills",jobService.getSkills());
        model.addAttribute("listRate", paging);
        return "jobs/jobs-paging";
    }
    @GetMapping("/search-by-skill")
    public String searchBySkill(Model model,@RequestParam("selectedSkill") String selectedSkill,
                                @RequestParam("page") Optional<Integer> page,
                                @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Job> paging = jobService.findAllBySkill(selectedSkill,currentPage-1,pageSize,"id","desc");
        model.addAttribute("paging",paging);
        int totalPages = paging.getTotalPages();
        if(totalPages >0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages)
                    .boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        model.addAttribute("skills",jobService.getSkills());
        return "jobs/jobs-paging";
    }

}
