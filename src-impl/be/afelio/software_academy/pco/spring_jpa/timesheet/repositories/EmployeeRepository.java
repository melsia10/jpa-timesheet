package be.afelio.software_academy.pco.spring_jpa.timesheet.repositories;

import be.afelio.software_academy.pco.spring_jpa.timesheet.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import javax.persistence.Table;


public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    EmployeeEntity findOneByFirstnameAndName(String firstname, String name);
    EmployeeEntity findOneByLoginAndPassword(String login, String password);
}
