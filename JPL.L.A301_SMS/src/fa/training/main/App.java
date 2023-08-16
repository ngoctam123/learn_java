package fa.training.main;
import fa.training.common.*;
import fa.training.dao.*;
import fa.training.entities.*;

public class App {
	private static CustomerDAO customerDAO = new CustomerDAOImpl();
    private static EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    private static ProductDAO productDAO = new ProductDAOImpl();
    private static OrderDAO orderDAO = new OrderDAOImpl();
    private static LineItemDAO lineItemDAO = new LineItemDAOImpl();

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

	}

}
