package user;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileManager<T> {

	/**
	 * 사용자 목록을 파일로 저장함.
	 */
	// 사용자 목록을 파일로 저장하는 메서드 ObjectOutputStream => output 사용해서 파일을 내보냄
		public void saveUsersToFile(List<User<T>> userList, String filename) {
			try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream (filename))){
				out.writeObject(userList);
				System.out.println("사용자 목록을 파일에 저장했습니다.");
			} catch (IOException e) {
				System.out.println("❌ 저장 중 오류 발생: " + e.getMessage());
	        }
		}
		
	/**
	 * 파일에서 사용자 목록을 불러옴.
	 */
	// 저장된 사용자 목록을 다시 불러오는 메서드  => input 으로 파일을 읽어옴
		public List<User<T>> loadUsersFromFile(String filename) {
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
				return (List<User<T>>) in.readObject();
			} catch (IOException | ClassNotFoundException e) {
				 System.out.println("❌ 불러오기 실패: " + e.getMessage());
		         return null;
			}
		}
	
}
