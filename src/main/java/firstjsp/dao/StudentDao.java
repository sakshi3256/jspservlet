package firstjsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import firstjsp.dto.Student;

public class StudentDao {
  
	public EntityManager getEManager()
	{
		return Persistence.createEntityManagerFactory("dev").createEntityManager();
		
	}
	
	public Student saveStudent(Student student)
	{
		EntityManager EM = getEManager();
		EntityTransaction t=EM.getTransaction();
		t.begin();
		EM.persist(student);
		t.commit();
		return student;
	}
	
	public List<Student> getAllStudent()
	{
		EntityManager EM = getEManager();
	Query q	=EM.createQuery("select a from Student a");
	List<Student> list =q.getResultList();
	return list;
		
	}
	
	public Student getStudentByEmail(String email)
	{
		EntityManager EM = getEManager();
   Query q	=EM.createQuery("select a from Student a where a.email=?1");
		q.setParameter(1, email);
	 Student s1=	(Student) q.getSingleResult();		
		return s1;
		
	}

	public void deleteStudentById(int id) {
		
		EntityManager EM=getEManager();
		Student student = EM.find(Student.class,id);
		if(student!=null)
		{
			EntityTransaction ET=EM.getTransaction();
			ET.begin();
			EM.remove(student);
			ET.commit();
		}
		
	}

	public Student updateStudent(int id,Student student) {
		
		EntityManager EM=getEManager();
		Student student1 = EM.find(Student.class,id);
		
		if(student1!=null)
		{
			EntityTransaction t = EM.getTransaction();
			t.begin();
			student.setStdid(id);
			EM.merge(student);
			t.commit();
			return student;
		}
		return null;
	
		
	}

	public Student getStudentById(int id) {
		EntityManager EM = getEManager();
		   Query q	=EM.createQuery("select a from Student a where a.id=?1");
				q.setParameter(1, id);
			 Student s1=	(Student) q.getSingleResult();		
				return s1;
	}
	
	
	
	
}
