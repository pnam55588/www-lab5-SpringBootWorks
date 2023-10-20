package fit.iuh.lab5.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_id", columnDefinition = "bigint(20)")
    private long id;
    @Column(name = "comp_name", columnDefinition = "varchar(255)")
    private String name;
    @Column(name = "about", columnDefinition = "varchar(2000)")
    private String about;
    @OneToOne
    @JoinColumn(name = "address", columnDefinition = "bigint(20)")
    @JsonBackReference
    private Address address;
    @Column(name = "phone", columnDefinition = "varchar(255)")
    private String phone;
    @Column(name = "web_url", unique = true)
    private String webURL;
    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY)
    private List<Job> job;
    @Column(name = "email", columnDefinition = "varchar(255)", unique = true)
    private String email;

}
