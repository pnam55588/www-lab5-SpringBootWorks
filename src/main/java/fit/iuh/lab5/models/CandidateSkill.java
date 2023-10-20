package fit.iuh.lab5.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import fit.iuh.lab5.enums.SkillLevel;
import fit.iuh.lab5.ids.IDCandidateSkill;
import jakarta.persistence.*;
import lombok.*;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidate_skill")
@IdClass(IDCandidateSkill.class)
public class CandidateSkill {
    @Column(name = "skill_Level",columnDefinition = "tinyint(4)")
    private SkillLevel skillLevel;
    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id", columnDefinition = "bigint(20)")
    @JsonBackReference
    private Skill skill;
    @Id
    @ManyToOne
    @JoinColumn(name = "can_id", columnDefinition = "bigint(20)")
    @JsonBackReference
    private Candidate candidate;
    @Column(name = "more_infos", columnDefinition = "varchar(1000)")
    private String moreInfo;

}
