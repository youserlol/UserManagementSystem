# UserManagementSystem

자바 콘솔 기반 사용자 관리 프로그램입니다.  
컬렉션, 제네릭, 예외 처리, JavaDoc 주석 등을 모두 실습하기 위해 제작된 통합 예제입니다.

---

## 📌 주요 기능

- 사용자 등록  
  → 중복 이메일 방지  
- 사용자 전체 조회  
  → List와 Iterator 활용  
- 사용자 삭제 요청  
  → 요청을 Queue에 담아 비동기 처리 시뮬레이션  
- 예외 처리  
  → 존재하지 않는 ID 조회 시 `UserNotFoundException` 발생  
- 제네릭(Generic) 활용  
  → ID 타입을 유연하게 처리  
- JavaDoc 주석 작성  
  → 코드 문서화 연습

---

## 🛠 기술 스택

- Java 17  
- Eclipse IDE  
- Git, GitHub  
- Java Collection Framework (List, Set, Map, Queue)  
- Generic, Exception Handling  
- JavaDoc 주석  

---

## 🗂️ 프로젝트 구조

UserManagementSystem/
├── src/
│ └── user/
│ ├── Main.java
│ ├── User.java
│ ├── UserManager.java
│ └── UserNotFoundException.java
├── README.md
└── module-info.java


---

## ✅ 실행 방법

1. Eclipse에서 `Main.java` 실행
2. 콘솔에서 사용자 등록 → 조회 → 삭제 요청 진행
3. 삭제 요청 큐를 실행하여 사용자 삭제

---

## 📎 예외 상황 예시

- 동일한 이메일로 등록 → “이미 등록된 이메일입니다.” 출력
- 존재하지 않는 ID 조회/삭제 → `UserNotFoundException` 발생

---

## 🚀 향후 개선 사항

- 파일 입출력 기능 추가  
- 객체 직렬화 기능 실습  
- 사용자 정보를 외부 파일로부터 로드/저장  
- GUI 기능 또는 웹 연동

---

## 👩‍💻 개발자

- **작성자**: youserlol 
- **GitHub**: [github.com/youserlol](https://github.com/youserlol)

