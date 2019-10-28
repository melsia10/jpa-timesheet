package be.afelio.software_academy.pco.spring_jpa.timesheet.entities;

import be.afelio.software_academy.jpa.exercice.timesheets.beans.Employee;
import be.afelio.software_academy.jpa.exercice.timesheets.beans.Prestation;
import be.afelio.software_academy.jpa.exercice.timesheets.beans.Project;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "Prestation")
@Table(name = "prestation")
public class PrestationEntity implements Prestation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date day;
    @ManyToOne
    @JoinColumn(name = "employee")
    private EmployeeEntity employee;
    @ManyToOne
    @JoinColumn(name = "project")
    private ProjectEntity project;
    private int duration;
    private String comment;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Date getDay() {
        return day;
    }

    @Override
    public Employee getEmployee() {
        return employee;
    }

    @Override
    public Project getProject() {
        return project;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public String getComment() {
        return comment;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrestationEntity that = (PrestationEntity) o;
        return duration == that.duration &&
                Objects.equals(id, that.id) &&
                Objects.equals(day, that.day) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, day, duration, comment);
    }
}
