/**
 * 
 */
package com.mystudy.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.transaction.Transactional;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.asm.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.mystudy.model.Student;
import com.mystudy.model.StudentSupervisorView;
import com.mystudy.model.Student_;
import com.mystudy.model.Team;
import com.mystudy.repository.StudentRepository;

/**
 * @author Keshav
 *
 */
@Repository
public class StudentDao{
	@Autowired
	StudentRepository studentRepository;
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public Student save(Student student) {
		Team team = entityManager.find(Team.class, student.getTeam().getTeamId());
		student.setTeam(team);
		return studentRepository.save(student);
	}

	public List<StudentSupervisorView> fetchStudentAndSupervisor() {
		StringBuffer sb = new StringBuffer();
		sb.append(" Select s.studentId as studentId, s.name as studentName, s.team.teamId as teamId,");
		sb.append(" s.team.teamCode as teamCode, tgm.user.userId as supervisorId, tgm.user.userName as supervisorName");
		sb.append(" from Student s");
		sb.append(" left join TaggingManagement tgm on s.team.teamId = tgm.team.teamId");
		List<StudentSupervisorView> list = new ArrayList<StudentSupervisorView>(); 
		StudentSupervisorView studentSupervisorView = null;
		List<Tuple> studentAndSupervisorTuple =  entityManager.createQuery(sb.toString(), Tuple.class).getResultList();
		for(Tuple t : studentAndSupervisorTuple) {
			studentSupervisorView = new StudentSupervisorView();
			studentSupervisorView.setStudentId(t.get("studentId", Long.class));
			studentSupervisorView.setStudentName(t.get("studentName", String.class));
			studentSupervisorView.setTeamId(t.get("teamId", Long.class));
			studentSupervisorView.setTeamCode(t.get("teamCode", String.class));
			studentSupervisorView.setSupervisorId(t.get("supervisorId", Long.class));
			studentSupervisorView.setSupervisorName(t.get("supervisorName", String.class));
			list.add(studentSupervisorView);
		}
		return list;
	}

	public void save1000Records(List<Student> students) {
		studentRepository.saveAll(students);
	}

	public List<Student> findRecords(int pageNumber, int pageLength) {
		return entityManager.createQuery("select s from Student s left join fetch s.team t order by s.studentId", Student.class)
				.setFirstResult((pageNumber - 1) * pageLength)
				.setMaxResults(pageLength)
				.getResultList();
	}
	public List<Student> findRecordsWithCritriaQuery(int pageNumber, int pageLength) {
		//criteria builder
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		//criteria query
		 CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
		 //get root
		Root<Student> root = criteria.from(Student.class);
		//constructing the parameters
		List<Predicate> predicates = new ArrayList<Predicate>();
		predicates.add(builder.equal(root.get("studentId"), 1));
		//predicates.add(builder.equal(root.get("studentId"), 1));
		criteria.select(root).where(predicates.toArray(new Predicate[] {}));
		return entityManager.createQuery(criteria).getResultList();
	}
	

	public long findRecordsCount() {
		return studentRepository.count();
	}
	
	public Page<Student> findWithPageable1(Pageable pageable) {
		return studentRepository.findAllWithPageable(pageable);
	}
	
	public void hqlTest() {
		entityManager.createQuery("");
	}

	public List<Student> findRecordsWithCriteria() {
/*		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
		Root<Student> root = criteria.from(Student.class);
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		//predicates.add(builder.equal(root.get("studentId"), 1));
		predicates.add(builder.like(root.<String>get("name"), "%5__"));
		//order by condition, we can add many comma separated condition in order by method
		criteria.orderBy(builder.desc(root.get("studentId")));
		criteria.select(root).where(predicates.toArray(new Predicate[] {}));
		return entityManager.createQuery(criteria).getResultList();
*/		
		//CriteriaQuery<Student> cq = equalCondition();
		//CriteriaQuery<Student> cq = lessThanCondition();
		//CriteriaQuery<Student> cq = multipleCondition();
//		CriteriaQuery<Student> cq = likeCondition();
//		CriteriaQuery<Student> cq = inCondition();
//		TypedQuery<Student> query = notLikeCondition();
//		TypedQuery<Student> query = joinFetch();
		
		
		TypedQuery<Tuple> query = joinLeft();
		List<Tuple> studentTeams = query.getResultList();
		List<Student> students = new ArrayList<Student>();
		studentTeams.forEach(t->{
			Student student = (Student) t.get("student");
			student.setTeam((Team) t.get("team"));
			students.add(student);
		});
		return students;
		
		//return null;
	}
	
	private CriteriaQuery<Student> equalCondition(){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		cq.where(cb.equal(root.get("name"), "Student 1"));
		return cq;
	}
	
	private CriteriaQuery<Student> lessThanCondition(){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		cq.where(cb.lessThan(root.get("dob"), LocalDate.of(2020, 1, 1)));
		return cq;
	}
	
	private CriteriaQuery<Student> multipleCondition(){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		cq.where(cb.lessThan(root.get("dob"), LocalDate.of(2020, 1, 1))
				,cb.greaterThan(root.get("dob"), LocalDate.of(1995, 7, 26))
		);
		return cq;
	}
	
	private CriteriaQuery<Student> likeCondition(){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		cq.where(cb.like(root.get("name"), "%5__"));
		return cq;
	}
	
	private TypedQuery<Student> notLikeCondition(){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		
		cq.where(cb.notLike(root.get(Student_.name), "student%"),
				cb.equal(root.get(Student_.studentId), "1")
				);
		
		TypedQuery<Student> query = entityManager.createQuery(cq);
		return query;
	}
	
	@SuppressWarnings("unchecked")
	private TypedQuery<Student> joinFetch(){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		Join<Student, Team> book = (Join<Student, Team>) root.fetch(Student_.team);
		
		//ParameterExpression<Long> pStudentId = cb.parameter(Long.class);
		//cq.where(cb.equal(root.get(Student_.studentId), pStudentId));
		
		TypedQuery<Student> query = entityManager.createQuery(cq);
		//query.setParameter(pStudentId, 1L);
		return query;
	}
	
	private TypedQuery<Tuple> joinLeft(){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> cq = cb.createTupleQuery();
		Root<Student> root = cq.from(Student.class);
		Join<Student, Team> book = (Join<Student, Team>) root.join(Student_.team, JoinType.LEFT);
		cq.multiselect(root.alias("student"), book.alias("team"));
		//ParameterExpression<Long> pStudentId = cb.parameter(Long.class);
		//cq.where(cb.equal(root.get(Student_.studentId), pStudentId));
		
		TypedQuery<Tuple> query = entityManager.createQuery(cq);
		query.setFirstResult(0);
		query.setMaxResults(10);
		//query.setParameter(pStudentId, 1L);
		return query;
	}
	
	private CriteriaQuery<Student> inCondition(){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		cq.where(root.get("name").in("Student 1", "Student 2"));
		return cq;
	}

	public List<Student> queryByMethodName() {
		//return studentRepository.findTop10ByOrderByStudentId();
		return studentRepository.findByNameStartingWithAndDobLessThan("Keshav", LocalDate.now());
	}
	
	
	
}
