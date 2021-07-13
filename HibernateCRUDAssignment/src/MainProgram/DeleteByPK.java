package MainProgram;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteByPK {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            System.out.println("Creating a new Employee...");
            Employee e1 = new Employee("Nick", "Walker", "UPS");
            System.out.println("Beginning a new transaction...");
            session.beginTransaction();
            System.out.println("Saving the new Employee...");
            System.out.println(e1);
            session.save(e1);
            session.getTransaction().commit();
            System.out.println("Employee was save. Id generated is: " + e1.getId());

           // int empId = e1.getId();
            session = factory.getCurrentSession();
            System.out.println("Beginning a new transaction...");
            session.beginTransaction();
            System.out.println("Getting Employee with id: " + e1.getId());
            Employee emp = session.get(Employee.class, e1.getId());
            System.out.println("Deleting Employee: " + emp);
            session.delete(emp);
            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            factory.close();
        }
    }
}
