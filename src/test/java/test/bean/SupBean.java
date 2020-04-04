package test.bean;

public class SupBean {
	private Integer id;
	private String name;
	private Integer age;
	private Character gender;
	private Boolean merry;
	private UserBean bean;
	
	public UserBean getBean() {
		return bean;
	}
	public void setBean(UserBean bean) {
		this.bean = bean;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
	public Boolean getMerry() {
		return merry;
	}
	public void setMerry(Boolean merry) {
		this.merry = merry;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((bean == null) ? 0 : bean.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((merry == null) ? 0 : merry.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		SupBean other = (SupBean) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (bean == null) {
			if (other.bean != null)
				return false;
		} else if (!bean.equals(other.bean))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (merry == null) {
			if (other.merry != null)
				return false;
		} else if (!merry.equals(other.merry))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SupBean [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", merry=" + merry
				+ ", bean=" + bean + "]";
	}
	
	
}
