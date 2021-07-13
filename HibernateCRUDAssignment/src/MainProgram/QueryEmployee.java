package MainProgram;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryEmployee {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            System.out.println("Beginning transaction...");
            session.beginTransaction();
            List<Employee> emps = session.createQuery("from Employee").getResultList();

            System.out.println("Displaying all Employees...");
            displayEmps(emps);

            emps = session.createQuery("from Employee e where company = 'Amazon'").getResultList();
            System.out.println("Displaying all the Employees for company 'Amazon'...");
            displayEmps(emps);

            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            factory.close();
        }
    }
    private static void displayEmps(List<Employee> emps) {
        for(Employee emp : emps) {
            System.out.println(emp);
        }
    }
}
