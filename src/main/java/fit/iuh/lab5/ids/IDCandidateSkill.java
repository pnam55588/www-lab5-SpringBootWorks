package fit.iuh.lab5.ids;

import fit.iuh.lab5.models.Candidate;
import fit.iuh.lab5.models.Skill;
import lombok.*;

import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class IDCandidateSkill implements Serializable {
    private Candidate candidate;
    private Skill skill;
}
