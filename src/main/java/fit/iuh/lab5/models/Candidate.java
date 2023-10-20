package fit.iuh.lab5.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidate")
public class Candidate {
    @Column(name = "phone",columnDefinition = "varchar(15)")
    private String phone;
    @Id
    @Column(name = "can_id",columnDefinition = "bigint(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "dob",columnDefinition = "date")
    private LocalDate dob;
    @Column(name = "email",columnDefinition = "varchar(255)",unique = true)
    private String email;
    @Column(name = "full_name",columnDefinition = "varchar(255)")
    private String fullName;
    @OneToOne
    @JoinColumn(name = "address", columnDefinition = "bigint(20)")
    @JsonBackReference
    private Address address;
    @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY)
    private List<CandidateSkill> candidateSkills;
    @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY)
    private List<Experience> experiences;
}
