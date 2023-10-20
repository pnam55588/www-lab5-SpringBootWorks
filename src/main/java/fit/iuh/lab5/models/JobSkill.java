package fit.iuh.lab5.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import fit.iuh.lab5.enums.SkillLevel;
import fit.iuh.lab5.ids.IDJobSkill;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "job_skill")
@IdClass(IDJobSkill.class)
public class JobSkill {
    @Column(name ="skill_level",columnDefinition = "tinyint(4)")
    private SkillLevel skillLevel;
    @Id
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name ="job_id",columnDefinition = "bigint(20)")
    @JsonBackReference
    private Job job;
    @Column(name ="more_infos",columnDefinition = "varchar(1000)")
    private String moreInfo;
    @Id
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name ="skill_id", columnDefinition = "bigint(20)")
    @JsonBackReference
    private Skill skill;
}
