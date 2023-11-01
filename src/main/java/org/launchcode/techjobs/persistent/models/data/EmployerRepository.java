package org.launchcode.techjobs.persistent.models.data;

import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//2.3.1.a EmployerRepository should extend CrudRepository
// 2.3.1.b Should be annotated with @Repository
@Repository
public interface EmployerRepository extends CrudRepository<Employer, Integer> {
}
