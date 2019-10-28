package be.afelio.software_academy.pco.spring_jpa.timesheet.repositories;

import be.afelio.software_academy.pco.spring_jpa.timesheet.entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
    ProjectEntity findOneByName(String name);
}
