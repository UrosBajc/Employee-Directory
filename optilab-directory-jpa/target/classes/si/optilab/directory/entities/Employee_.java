package si.optilab.directory.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import si.optilab.directory.entities.si.optilab.directory.entitiens.enums.Department;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SingularAttribute<Employee, String> surname;
	public static volatile SingularAttribute<Employee, String> name;
	public static volatile SingularAttribute<Employee, Integer> id;
	public static volatile SingularAttribute<Employee, Department> department;
	public static volatile SingularAttribute<Employee, String> internalNumber;

}

