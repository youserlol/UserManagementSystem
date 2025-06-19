import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class UserManager {
// 사용자 관리 클래스, 등록, 조회, 삭제 메서드 구현하기
	
	/*
	중복 이메일 방지 (Set 활용)
	사용자 리스트 출력 (ArrayList, LinkedList 활용)
	사용자 ID 기준 Map 관리 (HashMap)
	삭제 요청을 Queue에 담아 비동기 처리 시뮬레이션
	 */
	
	private Set <String> emailSet = new HashSet<>();
	private Map <String, User> userMap = new HashMap<>(); 
	private Queue <String> deleteQueue = new LinkedList<>();
	// 사용자 목록을 저장하고 출력하기 위한 ArrayList, 사용자 리스트를 관리하기 위함
	private List<User> userList = new ArrayList<>();
	
	// 사용자 등록 메서드
	public void registerUser(User user) {
		// 사용자 등록 하기 위해 이메일 중복 검사
		if (emailSet.contains(user.getEmail())) { 
			// contain() 함수는 특정 값이 집합에 존재하는지 확인할 수 있음
			System.out.println("이미 등록된 이메일입니다.");
            return;
		} 
		
		userMap.put(user.getId(), user);
		emailSet.add(user.getEmail());
		userList.add(user); // 사용자 리스트에 사용자 추가
		System.out.println("사용자가 등록되었습니다. " + "\n" + user);
	}
	
	// 사용자 조회 메서드 Iterator 인터페이스를 이용한다.
	public void showAllUser() {
		 System.out.println("등록된 사용자 목록:");
		 
		 Iterator<User> iterator = userList.iterator();
		 while (iterator.hasNext()) {
			User user = iterator.next();
			System.out.println(user);	 
		 }
	}
	
	public User getUserById (String id) throws UserNotFoundException {
		
		if(!userMap.containsKey(id)) {
			throw new UserNotFoundException("!! 해당 아이디를 찾을 수 없습니다 : " + id);
		}
		return userMap.get(id);
	}
	
	// 사용자 삭제 메서드 구현하기
	/*
	 1. 사용자 삭제 요청을 Queue에 저장하기
	 2. Queue에 담은 요청을 한번에 처리하기
	 3. 삭제 요청 시에 ( 큐에 저장할 때가 아닌 처리할 때)
	    Map에서 아이디가 있는지 확인 후 예외처리하기
	 */
	
	// 사용자 삭제 요청을 Queue에 담기
	public void requestDeleteQueue(String id) {
		deleteQueue.add(id);
		System.out.println("삭제 요청이 큐에 추가되었습니다 : ID = " + id);
	}
	
	// Queue에 담긴 요청을 예외 처리 후 삭제하기
	public void DeleteQueue() throws UserNotFoundException{
		// 만약 deleteQueue가 비어있지 않다면
		while(!deleteQueue.isEmpty()) {
			String id = deleteQueue.poll(); // 요청을 처리 후 요청 목록에서 제거
			if(!userMap.containsKey(id)) {
				throw new UserNotFoundException("삭제 실패 : ID " + id + " 사용자를 찾을 수 없습니다.");
			}
			
			User user = userMap.get(id);
			userMap.remove(id);
			userList.remove(user);
			
			System.out.println("삭제 완료: ID = " + id);
		}
	}

}
