
public class person {
	private String lastname;
	private int age;
	private String email;
	private Boolean gender;

	public person() {
	}

	public person(String lastname, int age, String email, Boolean gender) {
		this.lastname = lastname;
		this.age = age;
		this.email = email;
		this.gender = gender;
	}



	public person(String lastname, int age) {
		this.lastname = lastname;
		this.age = age;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "person{" +
			"lastname='" + lastname + '\'' +
			", age=" + age +
			", email='" + email + '\'' +
			", gender=" + gender +
			'}';
	}
}
