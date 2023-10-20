package fit.iuh.lab5.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id", columnDefinition = "bigint(20)")
    private long id;
    @Column(name = "to_date", columnDefinition = "date")
    private LocalDate toDate;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "can_id", columnDefinition = "bigint(20)")
    @JsonBackReference
    private Candidate candidate;
    @Column(name = "from_date", columnDefinition = "date")
    private LocalDate fromDate;
    @Column(name = "company", columnDefinition = "varchar(120)")
    private String companyName;
    @Column(name = "role", columnDefinition = "varchar(100)")
    private String role;
    @Column(name = "work_desc", columnDefinition = "varchar(400)")
    private String workDescription;
}
