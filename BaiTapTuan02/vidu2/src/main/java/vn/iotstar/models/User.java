package vn.iotstar.models;

public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	private String fullname;
	private String phone;

	// Constructor rỗng
	public User() {
	}

	// Constructor khi insert (không cần id vì DB tự tăng)
	public User(String username, String password, String email, String fullname, String phone) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.fullname = fullname;
		this.phone = phone;
	}

	// Constructor đầy đủ (dùng khi select từ DB ra)
	public User(int id, String username, String password, String email, String fullname, String phone) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.fullname = fullname;
		this.phone = phone;
	}

	// Getter & Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
