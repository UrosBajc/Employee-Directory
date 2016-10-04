package si.optilab.directory.entities;

import si.optilab.directory.entities.si.optilab.directory.entitiens.enums.Department;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Uros on 1. 10. 2016.
 */
@Entity
@Table(name = "employees", schema = "optilab_directory")
public class Employee implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="name", length = 45)
    private String name;

    @Column(name = "surname", length = 45)
    private String surname;

    @Enumerated(EnumType.ORDINAL)
    private Department department;

    @Column(name = "internal_number", length = 45)
    private String internalNumber;

    public Employee(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getInternalNumber() {
        return internalNumber;
    }

    public void setInternalNumber(String internalNumber) {
        this.internalNumber = internalNumber;
    }

    @Override
    public String toString(){
        return  this.name + " " + this.surname + ", " + this.department.toString() + ", " + this.internalNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee that = (Employee) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (department != null ? !department.equals(that.department) : that.department != null) return false;
        if (internalNumber != null ? !internalNumber.equals(that.internalNumber) : that.internalNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (internalNumber != null ? internalNumber.hashCode() : 0);
        return result;
    }
}
