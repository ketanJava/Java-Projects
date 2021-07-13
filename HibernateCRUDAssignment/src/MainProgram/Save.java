package MainProgram;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.xml.stream.FactoryConfigurationError;

public class Save {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            System.out.println("Creating three Employee Objects...");
            Employee e1 = new Employee("Jack", "Wilson", "Regex");
            Employee e2 = new Employee("Steve", "Hudson", "Fedex");
            Employee e3 = new Employee("John", "Williams", "Amazon");

            session.beginTransaction();
            System.out.println("Beginning transaction...");
            session.save(e1);
            session.save(e2);
            session.save(e3);
            System.out.println("Saving new Employees...");
            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            factory.close();
        }
    }
}
