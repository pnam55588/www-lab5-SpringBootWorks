package fit.iuh.lab5;

import com.neovisionaries.i18n.CountryCode;
import fit.iuh.lab5.enums.SkillLevel;
import fit.iuh.lab5.enums.SkillType;
import fit.iuh.lab5.models.*;
import fit.iuh.lab5.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
@RequiredArgsConstructor
public class Lab5Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab5Application.class, args);
	}



	private final AddressRepository addressRepository;
	private final SkillRepository skillRepository;
	private final JobRepository jobRepository;
	private final JobSkillRepository jobSkillRepository;
	private final CompanyRepository companyRepository;

	//	@Bean
	CommandLineRunner initCandidates(CandidateRepository candidateRepository){
		return args -> {
			Random random = new Random();
			for (int i =0; i<1000; i++){
				Address a = new Address();
				a.setCity("HCM");
				a.setCountry(CountryCode.VN);
				a.setZipcode(random.nextInt(70000,80000)+"");
				a.setStreet("Quang Trung");
				a.setNumber(random.nextInt(1,10000)+"");
				Candidate can = new Candidate();
				can.setAddress(a);
				can.setDob(LocalDate.of(1998,random.nextInt(1,12), random.nextInt(1,29)));
				can.setEmail("email_"+i+"@gmail.com");
				can.setPhone(random.nextLong(111111111,999999999)+"");
				can.setFullName("name #"+i);
				addressRepository.save(a);
				candidateRepository.save(can);
			}
		};
	}
	@Bean
	CommandLineRunner initCompanies(){
		return args -> {
			Random random = new Random();

			Skill sk1= new Skill();
			sk1.setSkillName("java");
			sk1.setSkillType(SkillType.TECHNICAL_SKILL);
			sk1.setSkillDescription("skill init");
			skillRepository.save(sk1);
			Skill sk2= new Skill();
			sk2.setSkillName("spring boot");
			sk2.setSkillType(SkillType.TECHNICAL_SKILL);
			sk2.setSkillDescription("skill init");
			skillRepository.save(sk2);
			for(int i=0;i<100;i++){

				System.out.println("lan a"+i);
				Address a = new Address();
				a.setCity("Ha Noi");
				a.setCountry(CountryCode.VN);
				a.setZipcode(random.nextInt(70000,80000)+"");
				a.setStreet("Hoang Dieu");
				a.setNumber(random.nextInt(1,10000)+"");
				addressRepository.save(a);

				System.out.println("lan b"+i);
				Company com = new Company();
				com.setPhone(random.nextInt(random.nextInt(111111111,999999999))+"");
				com.setEmail("company_"+i+"@gmail.com");
				com.setAddress(a);
				com.setWebURL("http://company_"+i);
				com.setAbout("company init");
				companyRepository.save(com);

				System.out.println("lan c"+i);

				Job job = new Job();
				job.setCompany(com);
				job.setName("job "+i);
				job.setDescription("job init");
				jobRepository.save(job);
				System.out.println(job);

				System.out.println("lan e"+i);
				JobSkill jobSkill = new JobSkill();
				jobSkill.setSkillLevel(SkillLevel.IMTERMEDIATE);
				jobSkill.setJob(job);
				jobSkill.setSkill(sk1);
				jobSkill.setMoreInfo("init");
				jobSkillRepository.save(jobSkill);
				System.out.println(jobSkill);
			}
		};
	}


}
