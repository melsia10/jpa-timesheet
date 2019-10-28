package be.afelio.software_academy.pco.spring_jpa.timesheet.entities;


import be.afelio.software_academy.jpa.exercice.timesheets.beans.Employee;
import be.afelio.software_academy.jpa.exercice.timesheets.beans.Project;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "Project")
@Table(name = "project")
public class ProjectEntity implements Project {
    @Id
    @Column(name="id")
    private Long id;
    private String name;
    private String description;
    private Date startdate;
    private Date enddate;
    @ManyToOne
    @JoinColumn(name = "manager")
    private EmployeeEntity manager;
    @OneToMany(mappedBy = "project")
    List<PrestationEntity> prestationList;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Date getStartDate() {
        return startdate;
    }

    @Override
    public Date getEndDate() {
        return enddate;
    }

    @Override
    public Employee getManager() {
        return manager;
    }

    @Override
    public String toString() {
        return "ProjectEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectEntity that = (ProjectEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(startdate, that.startdate) &&
                Objects.equals(enddate, that.enddate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, startdate, enddate);
    }
}
