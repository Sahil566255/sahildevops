
package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import model.Student;
 
@Repository
public class StudentDAOImpl implements StudentDAO {
    private SessionFactory sessionFactory;
	
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
   
    public void addStudent(Student s) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(s);
    }

  
  public void updateStudent(Student s) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(s);
    }

    @SuppressWarnings("unchecked")
   
    public List<Student> listStudents() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Student> studentsList = session.createQuery("from Student").list();
        return studentsList;
    }

    @Override
    public Student getStudentById(int id) {
        Session session = this.sessionFactory.getCurrentSession();		
        Student s = (Student) session.load(Student.class, new Integer(id));
        return s;
    }

    @Override
    public void removeStudent(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Student s = (Student) session.load(Student.class, new Integer(id));
        if(null != s){
            session.delete(s);
        }
    }
}
