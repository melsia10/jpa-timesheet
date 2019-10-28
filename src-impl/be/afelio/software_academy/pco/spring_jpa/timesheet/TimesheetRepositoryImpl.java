package be.afelio.software_academy.pco.spring_jpa.timesheet;

import be.afelio.software_academy.jpa.exercice.timesheets.TimesheetsRepository;
import be.afelio.software_academy.jpa.exercice.timesheets.beans.Employee;
import be.afelio.software_academy.jpa.exercice.timesheets.beans.Prestation;
import be.afelio.software_academy.jpa.exercice.timesheets.beans.Project;
import be.afelio.software_academy.pco.spring_jpa.timesheet.entities.EmployeeEntity;
import be.afelio.software_academy.pco.spring_jpa.timesheet.entities.PrestationEntity;
import be.afelio.software_academy.pco.spring_jpa.timesheet.entities.ProjectEntity;
import be.afelio.software_academy.pco.spring_jpa.timesheet.repositories.EmployeeRepository;
import be.afelio.software_academy.pco.spring_jpa.timesheet.repositories.PrestationRepository;
import be.afelio.software_academy.pco.spring_jpa.timesheet.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TimesheetRepositoryImpl implements TimesheetsRepository {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    PrestationRepository prestationRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<? extends Employee> findAllEmployees() {
        List<EmployeeEntity> employeeEntityList = new ArrayList<>();
        return employeeEntityList = employeeRepository.findAll();
    }

    @Override
    public Employee findOneEmployeeById(long id) {
        return employeeRepository.findOne((id));
    }

    @Override
    public Employee findOneEmployeeByFirstnameAndName(String firstname, String name) {
        return employeeRepository.findOneByFirstnameAndName(firstname, name);
    }

    @Override
    public Employee findOneEmployeeByLoginAndPassword(String login, String password) {
        return employeeRepository.findOneByLoginAndPassword(login,password);
    }

    @Override
    public List<? extends Project> findAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project findOneProjectById(long id) {
        return projectRepository.findOne(id);
    }

    @Override
    public Project findOneProjectByName(String name) {
        return projectRepository.findOneByName(name);
    }

    @Override
    public Prestation findOnePrestationById(long id) {
        return prestationRepository.findOne(id);
    }

    @Override
    public List<? extends Prestation> findAllPrestationsByEmployeeId(long id) {
        return prestationRepository.findAllByEmployeeId(id);
    }

    @Override
    public List<? extends Prestation> findAllPrestationsByProjectId(long id) {
        return prestationRepository.findAllByProjectId(id);
    }

    @Override
    public Prestation addPrestation(long employeeId, long projectId, String comment, Date day, int duration) {
        PrestationEntity prestation = new PrestationEntity();
        EmployeeEntity employe = employeeRepository.findOne(employeeId);
        ProjectEntity project = projectRepository.findOne(projectId);
        if (employe != null && project != null && comment != null && !comment.isBlank() && day != null && duration!= 0){
            prestation.setEmployee(employe);
            prestation.setComment(comment);
            prestation.setDay(day);
            prestation.setDuration(duration);
            prestation.setProject(project);
            prestationRepository.save(prestation);
        }


        return prestation;
    }

    @Override
    public Prestation deletePrestation(long id) {
        PrestationEntity prestation = prestationRepository.findOne(id);
        if(prestation != null){
            prestationRepository.delete(prestation);
        }
        return prestation;
    }
}
