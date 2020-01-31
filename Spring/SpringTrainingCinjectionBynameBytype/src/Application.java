
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.krishantha.training.salesmanager.model.Employee;
import com.krishantha.training.salesmanager.service.EmployeeService;

public class Application {
	public static void main(String[] args) {

	ApplicationContext applicationContext= new ClassPathXmlApplicationContext("applicationContext.xml");
	//methanata danne Bean name eka one ekak danna puluwan,
	//employee service kiyanne implemented interface eka
	EmployeeService employeeService=applicationContext.getBean("modaManitha",EmployeeService.class);
	
//List<Employee> employees= new EmployeeServiceImpl().getAllEmployees(); replace by  
List<Employee> employees= employeeService.getAllEmployees();

for(Employee e:employees){
System.out.println(e.getEmployeeName()+" "+e.getEmployeeLocation());
}
}
}
