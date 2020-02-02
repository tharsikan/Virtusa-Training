

import java.text.Annotation;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.krishantha.training.salesmanager.model.Employee;
import com.krishantha.training.salesmanager.service.EmployeeService;

public class Application {
public static void main(String[] args) {

	ApplicationContext applicationContext= new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	EmployeeService employeeService=applicationContext.getBean("employeeService",EmployeeService.class);
	
List<Employee> employees= employeeService.getAllEmployees();
for(Employee e:employees){
System.out.println(e.getEmployeeName()+" "+e.getEmployeeLocation());
}
}
}
