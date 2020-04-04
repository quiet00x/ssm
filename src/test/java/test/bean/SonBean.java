package test.bean;

import java.math.BigDecimal;

public class SonBean extends SupBean{
	private String Employer;
	private String Job;
	private BigDecimal Salary;
	public String getEmployer() {
		return Employer;
	}
	public void setEmployer(String employer) {
		Employer = employer;
	}
	public String getJob() {
		return Job;
	}
	public void setJob(String job) {
		Job = job;
	}
	public BigDecimal getSalary() {
		return Salary;
	}
	public void setSalary(BigDecimal salary) {
		Salary = salary;
	}
	@Override
	public String toString() {
		return "SonBean [Employer=" + Employer + ", Job=" + Job + ", Salary=" + Salary + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Employer == null) ? 0 : Employer.hashCode());
		result = prime * result + ((Job == null) ? 0 : Job.hashCode());
		result = prime * result + ((Salary == null) ? 0 : Salary.hashCode());
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
		SonBean other = (SonBean) obj;
		if (Employer == null) {
			if (other.Employer != null)
				return false;
		} else if (!Employer.equals(other.Employer))
			return false;
		if (Job == null) {
			if (other.Job != null)
				return false;
		} else if (!Job.equals(other.Job))
			return false;
		if (Salary == null) {
			if (other.Salary != null)
				return false;
		} else if (!Salary.equals(other.Salary))
			return false;
		return true;
	}
	
	
}
