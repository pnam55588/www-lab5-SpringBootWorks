package fit.iuh.lab5.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id", columnDefinition = "bigint(20)")
    private long id;
    @Column(name = "job_name", columnDefinition = "varchar(255)")
    private String name;
    @ManyToOne
    @JoinColumn(name = "company",columnDefinition = "bigint(20)")
    @JsonBackReference
    private Company company;
    @OneToMany(mappedBy = "job")
    private List<JobSkill> jobSkills;
    @Column(name = "job_desc", columnDefinition = "varchar(2000)")
    private String description;
}
