package be.afelio.software_academy.pco.spring_jpa.timesheet.repositories;

import be.afelio.software_academy.pco.spring_jpa.timesheet.entities.PrestationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrestationRepository extends JpaRepository<PrestationEntity, Long>{

    List<PrestationEntity> findAllByEmployeeId(long id);
    List<PrestationEntity>  findAllByProjectId(long id);

}
