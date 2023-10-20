package fit.iuh.lab5.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Column(name = "city",columnDefinition = "varchar(50)")
    private String city;
    @Column(name = "country",columnDefinition = "smallint(6)")
    private CountryCode country;
    @Id
    @Column(name = "add_id",columnDefinition = "bigint(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "zipcode",columnDefinition = "varchar(7)")
    private String zipcode;
    @Column(name = "street",columnDefinition = "varchar(150)")
    private String street;
    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    @JsonBackReference
    private Candidate candidate;
    @Column(name = "number",columnDefinition = "varchar(20)")
    private String number;
    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    @JsonBackReference
    private Company company;
}
