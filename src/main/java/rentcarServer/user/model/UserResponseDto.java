package rentcarServer.user.model;

public class UserResponseDto {
	private String id;
	private String email;
	private String name;
	private String birth;
	private String gender;
	private String country;
	private String telecom;
	private String phone;
	
	public UserResponseDto(String id, String email, String name, String birth, String gender, String country, String telecom,
			String phone) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.country = country;
		this.telecom = telecom;
		this.phone = phone;
	}
	
	public UserResponseDto(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.name = user.getName();
		this.birth = user.getBirth();
		this.gender = user.getGender();
		this.country = user.getCountry();
		this.telecom = user.getTelecom();
		this.phone = user.getPhone();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTelecom() {
		return telecom;
	}

	public void setTelecom(String telecom) {
		this.telecom = telecom;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return String.format("%s/%s/%s", this.id, this.name, this.email);
	}
}
