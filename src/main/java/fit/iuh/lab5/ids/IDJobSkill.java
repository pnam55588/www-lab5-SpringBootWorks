package fit.iuh.lab5.ids;

import fit.iuh.lab5.models.Job;
import fit.iuh.lab5.models.Skill;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class IDJobSkill implements Serializable {
    private Job job;
    private Skill skill;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IDJobSkill that = (IDJobSkill) o;
        return Objects.equals(job, that.job) && Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, skill);
    }
}
