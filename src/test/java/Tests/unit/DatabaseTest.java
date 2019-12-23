package Tests.unit;

import java.util.Date;

import org.hibernate.Session;
import database.model.Employee;
import database.utils.HibernateUtil;

class DatabaseTest {

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("Nazar");
		emp.setRole("ATQC");
        emp.setInsertTime(new Date());

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        session.save(emp);
        session.getTransaction().commit();

        System.out.println("Employee ID="+emp.getId());
        HibernateUtil.getSessionFactory().close();
    }
}