/**
 * 
 */
package com.mystudy.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;

import org.springframework.stereotype.Repository;

import com.mystudy.model.QuestionReport;
import com.mystudy.model.StudentReportView;

/**
 * @author Keshav
 *
 */
@Repository
public class StudentAssessmentReportDao {
	@PersistenceContext
	EntityManager entityManager;

	public List<StudentReportView> getStudentAssessmentDetailedReport(long teamId, long testId) {
		StringBuffer qs = new StringBuffer();
		qs.append(" SELECT st.test_id as testId, tm.test_name as testName, st.exam_start_time as examStartTime");
		qs.append(" , st.exam_end_time as examEndTime, st.score as assessmentScore");
		qs.append(" , ss.team_id as teamId, tmm.team_code as teamCode, st.student_id as studentId");
		qs.append(" , ss.first_name as firstName, ss.last_name as lastName");
		qs.append(" , ss.curriculum as curriculum, ss.callido_level as callidoLevel");
		qs.append(" , st.consumed_time as consumedTime");
		qs.append(" , case when st.test_status is null then 'Not started' else st.test_status end as testStatus");
		qs.append(" , sa.question_id as questionId, sa.score as questionScore");
		qs.append(" , sa.question_response_time as quesResponceTime");
		qs.append(" FROM student_test st, student_assessment sa, test_master tm");
		qs.append(" , school_student ss, team_master tmm");
		qs.append(" WHERE st.test_id = sa.test_id ");
		qs.append(" AND st.student_id = sa.student_id ");
		qs.append(" AND st.test_id = tm.test_id ");
		qs.append(" AND st.student_id = ss.student_id ");
		qs.append(" AND ss.team_id = tmm.team_id ");
		qs.append(" AND ss.team_id IN (" + teamId + ")");
		qs.append(" AND st.test_id IN (" + testId + ")");
		qs.append(" AND st.deleted_by IS NULL ");
		qs.append(" AND tm.deleted_by IS NULL ");
		qs.append(" AND ss.deleted_by IS NULL ");
		qs.append(" AND tmm.deleted_by IS NULL ");
		qs.append(" ORDER BY st.student_id ASC, sa.question_id ASC ");

		// JPA
		@SuppressWarnings("unchecked")
		List<Tuple> results = entityManager.createNativeQuery(qs.toString(), Tuple.class).getResultList();

		// Hibernate
		/*
		 * Session session = entityManager.unwrap(Session.class); List<Tuple> results =
		 * session.createNativeQuery(qs.toString(), Tuple.class) .addScalar("testId",
		 * StandardBasicTypes.LONG) .addScalar("testName", StandardBasicTypes.STRING)
		 * .addScalar("teamId", StandardBasicTypes.LONG) .addScalar("teamCode",
		 * StandardBasicTypes.STRING) .addScalar("studentId", StandardBasicTypes.LONG)
		 * .addScalar("firstName", StandardBasicTypes.STRING) .addScalar("lastName",
		 * StandardBasicTypes.STRING) .addScalar("assessmentScore",
		 * StandardBasicTypes.INTEGER) .addScalar("consumedTime",
		 * StandardBasicTypes.LONG) .addScalar("questionId", StandardBasicTypes.LONG)
		 * .addScalar("questionScore", StandardBasicTypes.SHORT)
		 * .addScalar("quesResponceTime", StandardBasicTypes.LONG)
		 * .addScalar("examStartTime", StandardBasicTypes.) .list();
		 */
		System.out.println("total rows = " + results.size());
		StudentReportView studentReportView = null;
		long previousStudentId = 0;
		List<StudentReportView> studentReportViews = new ArrayList<StudentReportView>();
		for (Tuple tuple : results) {
			Long currStudentId = tuple.get("studentId", Number.class).longValue();
			if (currStudentId != previousStudentId) {
				previousStudentId = currStudentId;
				studentReportView = new StudentReportView();
				studentReportView.setStudentId(currStudentId);
				studentReportView.setFirstName(tuple.get("firstName", String.class));
				studentReportView.setLastName(tuple.get("lastName", String.class));
				studentReportView.setTestId(tuple.get("testId", Number.class).longValue());
				studentReportView.setTestName(tuple.get("testName", String.class));
				studentReportView.setTeamId(tuple.get("teamId", Number.class).longValue());
				studentReportView.setTeamCode(tuple.get("teamCode", String.class));
				studentReportView.setExamStartDate(tuple.get("examStartTime", Timestamp.class).toLocalDateTime());
				studentReportView.setExamEndDate(tuple.get("examEndTime", Timestamp.class).toLocalDateTime());
				if (tuple.get("assessmentScore", Integer.class) != null) {
					studentReportView.setAssessmentScore(tuple.get("assessmentScore", Number.class).shortValue());
				}
				studentReportView
						.setTotalConsumedTime(convertToMinAndSec(tuple.get("consumedTime", Number.class).longValue()));
				studentReportView.setTestStatus(tuple.get("testStatus", String.class));

				studentReportView.getQuestionReports().add(getQuestionReport(tuple));
				studentReportViews.add(studentReportView);
			} else {
				studentReportView.getQuestionReports().add(getQuestionReport(tuple));
			}
		}

		return studentReportViews;
	}

	private QuestionReport getQuestionReport(Tuple tuple) {
		QuestionReport questionReport = new QuestionReport();
		questionReport.setQuestionId(tuple.get("questionId", Number.class).intValue());
		questionReport.setScore(tuple.get("questionScore", Number.class).intValue());
		questionReport.setQuesResponceTime(convertToMinAndSec(tuple.get("quesResponceTime", Number.class).longValue()));
		return questionReport;
	}

	public String convertToMinAndSec(Long time) {

		int minutes = (int) ((time / 1000) / 60);
		int seconds = (int) ((time / 1000) % 60);

		return "" + minutes + " Min " + seconds + " Sec";
	}
}
