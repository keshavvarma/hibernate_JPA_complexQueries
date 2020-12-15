/**
 * 
 */
package com.mystudy.model;

import java.time.LocalDate;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * @author Keshav
 *
 */
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Student.class)
public class Student_ {
	public static volatile SingularAttribute<Student, String> name;
    public static volatile SingularAttribute<Student, Long> studentId;
    public static volatile SingularAttribute<Student, LocalDate> dob;
    public static volatile SingularAttribute<Student, Team> team;
}
