package si.optilab.directory.ejb.beans;

import si.optilab.directory.entities.Employee;
import si.optilab.directory.entities.Employee_;
import si.optilab.directory.entities.si.optilab.directory.entitiens.enums.Department;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Uros on 2. 10. 2016.
 */
@Stateless
@Local(EmployeesServiceSBLocal.class)
@Remote(EmployeesServiceSBRemote.class)
public class EmployeesServiceSB implements EmployeesServiceSBLocal, EmployeesServiceSBRemote{

    private static final Logger LOGGER = Logger.getLogger(EmployeesServiceSB.class.getName());

    @PersistenceContext(unitName = "optilab-directory-db")
    private EntityManager em;

    public EmployeesServiceSB() {
    }

    public Employee getEmployee(int id) throws Exception {
        try {
            Employee emp = em.find(Employee.class, id);
            return emp;
        }
        catch (Exception e){
            throw new Exception("Error when trying to find employee with id " + id + " (" + e.getMessage() + ").");
        }
    }



    public void insertEmployee(HashMap<String, String> data) throws Exception {
        Employee emp = null;
        try {
            if(data.get("id") == null) {
                emp = new Employee();
            }
            else{
                emp = em.find(Employee.class, Integer.parseInt(data.get("id")));
            }

            emp.setDepartment(getDepartment(data.get("department")));
            emp.setName(data.get("name"));
            emp.setSurname(data.get("surname"));
            emp.setInternalNumber(data.get("internalNumber"));

            if(data.get("id") == null) {
                em.persist(emp);
            }
            else{
                em.merge(emp);
            }
        }catch (Exception e){
            LOGGER.warning("Inserting new user failed : " + e.getMessage());
        }
    }

    public void removeEmployee(int id) throws Exception {
        Employee emp = em.find(Employee.class, id);
        if(emp != null){
            em.remove(emp);
        }
        else{
            throw new Exception("Error when trying to remove employee with id " + id + " (employee does not exist in database).");
        }
    }

    public List<Employee> getEmployeesByDepartment(String departmentStr) throws Exception {
        Department department = getDepartment(departmentStr);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> emp = cq.from(Employee.class);
        cq.select(emp);
        if(!departmentStr.equals("all")) {
            cq.where(cb.equal(emp.get(Employee_.department), department));
        }
        TypedQuery tq = em.createQuery(cq);
        List<Employee> employees = tq.getResultList();
        if(employees != null)
            return employees;
        else
            return new ArrayList<Employee>();
    }

    private Department getDepartment(String department){
        switch (department){
            case "finance":
                return Department.FINANCE;
            case "sales":
                return Department.SALES;
            case "development":
                return Department.DEVELOPMENT;
            default:
                return Department.ADMINISTRATIVE;
        }
    }
}
