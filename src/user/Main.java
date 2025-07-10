package user;

import java.util.List;
import java.util.Scanner;

public class Main {
// 실행부
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);

		UserManager<Integer> userManager = new UserManager<>();
		FileManager<Integer> fileManager = new FileManager<>();
		
		User<Integer> user1 = new User("1", 25, "홍길동", "hong@example.com");
	    User<Integer> user2 = new User("2", 22, "이영희", "lee@example.com");
	    User<Integer> user3 = new User("3", 30, "홍길동", "hong@example.com"); // 중복 이메일

	    userManager.registerUser(user1);  // 성공
	    userManager.registerUser(user2);  // 성공
	    userManager.registerUser(user3);  // 실패 (중복 이메일)

	    userManager.showAllUser();
		
		try {
			User<Integer> found = userManager.getUserById(1);
			System.out.println("조회된 사용자 : " +  found);
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			User notFound = userManager.getUserById(99);
			System.out.println("조회된 사용자 : " + notFound);
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		// 삭제 요청하기
		userManager.requestDeleteQueue(1);
		userManager.requestDeleteQueue(4); // 존재하지 않음으로 예외 처리 될 것임.
		
		try {
			userManager.DeleteQueue();
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
		// 남은 사용자를 확인하여 사용자가 삭제되었는지 확인하기
		userManager.showAllUser();
		
		List<User<Integer>> userList = userManager.getUserList();
		// 1. 저장
		fileManager.saveUsersToFile(userList, "users.dat");

		// 2. 불러오기
		List<User<Integer>> loaded = fileManager.loadUsersFromFile("users.dat");

		// 3. 결과 확인
		System.out.println("✨ 저장된 사용자 목록 다시 불러오기:");
		for (User<Integer> user : loaded) {
		    System.out.println(user);  // toString()이 잘 구현돼 있으면 깔끔하게 출력돼
		}
 	}
}
