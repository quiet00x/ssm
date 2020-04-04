package com.bangb.user.bean;

import org.codehaus.jackson.map.annotate.JsonView;
import org.springframework.stereotype.Repository;

import com.bangb.common.view.SimpleView;

import lombok.Data;

@Data
@Repository
public class ClassDept {
	
	private String classId;
	
	private Teacher teacher;
	
	private Student student;

	@JsonView(SimpleView.class)
	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	@JsonView(SimpleView.class)
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@JsonView(SimpleView.class)
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classId == null) ? 0 : classId.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
		result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassDept other = (ClassDept) obj;
		if (classId == null) {
			if (other.classId != null)
				return false;
		} else if (!classId.equals(other.classId))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		if (teacher == null) {
			if (other.teacher != null)
				return false;
		} else if (!teacher.equals(other.teacher))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClassDept [classId=" + classId + ", teacher=" + teacher + ", student=" + student + "]";
	}

	
}
