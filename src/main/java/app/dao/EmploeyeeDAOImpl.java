package app.dao;


import app.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    SessionFactory sessionFactory;



    @Override
    public List<Employee> getAllEmployees() {

        Session session =  sessionFactory.getCurrentSession();
        List<Employee> allEmp =  session.createQuery(" select e from Employee e", Employee.class).getResultList();

        return  allEmp;
    }

    @Override
    public void saveEmployee(Employee emp) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(emp);
    }

    @Override
    public Employee getEmployee(int id) {
       Session session =  sessionFactory.getCurrentSession();

        return session.get(Employee.class, id);

    }

    @Override
    public void deleteEmployee(int id) {
        Session session =  sessionFactory.getCurrentSession();
        Query<Employee> employeeQuery = session.createQuery("delete from Employee where id=:employeeId");
        employeeQuery.setParameter("employeeId", id);
        employeeQuery.executeUpdate();
    }
}
