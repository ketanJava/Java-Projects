package MainProgram;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RetrieveByPK {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            System.out.println("Creating new Employee object...");
            Employee e1 = new Employee("Mark", "Jackson", "Amazon");
            session.beginTransaction();
            System.out.println("Beginning transaction...");

            System.out.println("Saving new Employee Object...");
            System.out.println(e1);
            session.save(e1);
            session.getTransaction().commit();
            System.out.println("Employee is saved. Generated id is: " + e1.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Getting Employee with id: " + e1.getId());
            Employee e2 = session.get(Employee.class, e1.getId());
            System.out.println("Got Employee: " + e2);

            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            factory.close();
        }
    }
}
