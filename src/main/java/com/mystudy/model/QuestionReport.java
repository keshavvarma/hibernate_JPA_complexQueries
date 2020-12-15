/**
 * 
 */
package com.mystudy.model;

/**
 * @author om
 *
 */
public class QuestionReport {
	private long questionId;
	private int score;
	private String quesResponceTime;

	public QuestionReport() {
	}

	public long getQuestionId() {
		return questionId;
	}

	public int getScore() {
		return score;
	}

	public String getQuesResponceTime() {
		return quesResponceTime;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setQuesResponceTime(String quesResponceTime) {
		this.quesResponceTime = quesResponceTime;
	}
}
