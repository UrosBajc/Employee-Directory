package si.optilab.directory.ejb.beans;

import si.optilab.directory.entities.Employee;
import si.optilab.directory.entities.si.optilab.directory.entitiens.enums.Department;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Uros on 1. 10. 2016.
 */
public interface EmployeesServiceSBLocal {

    Employee getEmployee(int id) throws Exception;

    void insertEmployee(HashMap<String, String> data) throws Exception;

    void removeEmployee(int id) throws Exception;

    List<Employee> getEmployeesByDepartment(String departmentStr) throws Exception;

}
