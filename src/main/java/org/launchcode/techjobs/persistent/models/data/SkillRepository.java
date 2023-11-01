package org.launchcode.techjobs.persistent.models.data;
//2.3.2.a EmployerRepository should extend CrudRepository
//2.3.2.b Should be annotated with @Repository

import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {
}
