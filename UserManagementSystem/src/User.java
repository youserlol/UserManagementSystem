
public class User<T> {
// 제네릭 User 클래스
	
	private int age;
	private T id;
	private String name;
	private String email;
	
	// 생성자 정의
	public User (T id, int age, String name, String email) {
		this.name = name;
		this.age= age;
		this.email = email;
		this.id = id;
	}
	
	// getter 함수
	public T getId() {
		return id;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}
	
	// 객체를 문자열로 리턴하는 메서드, 가장 많이 사용된다.
	// Object 클래스의 메서드기에 사용시마다 재정의해서 사용하는 것이 바람직하다.
	public String toString() {
		return "User{id=" + id + ", name='" + name + "', age=" + age + ", email='" + email + "'}";
	}
}
