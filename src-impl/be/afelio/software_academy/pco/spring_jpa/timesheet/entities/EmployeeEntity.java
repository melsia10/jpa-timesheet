package be.afelio.software_academy.pco.spring_jpa.timesheet.entities;


import be.afelio.software_academy.jpa.exercice.timesheets.beans.Employee;
import be.afelio.software_academy.jpa.exercice.timesheets.beans.Prestation;
import be.afelio.software_academy.jpa.exercice.timesheets.beans.Project;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "Employee")
@Table(name = "employee")
public class EmployeeEntity implements Employee {
    @Id
    @Column(name="id")
    private Long id;
    private String firstname;
    private String name;
    private String login;
    private String password;
    @OneToMany(mappedBy = "manager")
    List<ProjectEntity> projectList;
    @OneToMany(mappedBy = "employee")
    List<PrestationEntity> prestationList;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getFirstname() {
        return firstname;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public List<? extends Project> getManagedProjects() {
        return projectList;
    }

    @Override
    public List<? extends Prestation> getPrestations() {
        return prestationList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(name, that.name) &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, name, login, password);
    }
}
