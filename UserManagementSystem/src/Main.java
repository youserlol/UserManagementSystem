import java.util.Scanner;

public class Main {
// 실행부
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		UserManager um = new UserManager();
		
		User user1 = new User("1", 25, "홍길동", "hong@example.com");
	    User user2 = new User("2", 22, "이영희", "lee@example.com");
	    User user3 = new User("3", 30, "홍길동", "hong@example.com"); // 중복 이메일

	    um.registerUser(user1);  // 성공
	    um.registerUser(user2);  // 성공
	    um.registerUser(user3);  // 실패 (중복 이메일)

		um.showAllUser();
		
		try {
			User found = um.getUserById("1");
			System.out.println("조회된 사용자 : " +  found);
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			User notFound = um.getUserById("99");
			System.out.println("조회된 사용자 : " + notFound);
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		// 삭제 요청하기
		um.requestDeleteQueue("1");
		um.requestDeleteQueue("4"); // 존재하지 않음으로 예외 처리 될 것임.
		
		try {
			um.DeleteQueue();
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
		// 남은 사용자를 확인하여 사용자가 삭제되었는지 확인하기
		um.showAllUser();
 	}

}
