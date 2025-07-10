package user;

public class UserNotFoundException extends Exception {
// 사용자 정의 예외, userMap에 ID가 없을 경우 
	public UserNotFoundException(String message) {
		super(message);
	}
	
}
