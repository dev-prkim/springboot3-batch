<h1>Spring Boot 3 배치 샘플 프로젝트</h1>

이 프로젝트는 Spring Boot 3을 사용하는 Spring Batch 프로젝트 예제입니다. 이 프로젝트의 목적은 Spring Batch 애플리케이션의 간단한 설정을 보여주는 것입니다.

### 기술 스택

* Spring Boot 3
* Spring Batch
* H2

### 샘플 배치 작업들

* 회원 탈퇴 프로세스(매일 03시)
  : 탈퇴 요청 후 14일 지난 회원의 정보를 히스토리 테이블로 이관합니다.
    
    * 프로세스 정의                      
      * Read: 상태가 '탈퇴대기'인 User 엔티티를 조회합니다.
      * Process: User 의 상태를 '탈퇴'로 변경합니다.
      * Write: UserWithdrawal 엔티티로 이관합니다. 

* 상품 자동 활성화 프로세스(매일 00시)
  : 판매 시작일이 도래한 상품의 상태값을 자동으로 활성화 합니다.

  * 프로세스 정의
    * Read: 상태가 '판매예정' Product 엔티티를 조회합니다. 
    * Process: Product 의 상태를 '판매중' 으로 변경합니다.
    * Write: 상품 변경사항을 로깅합니다.

* 상품 자동 비활성화 프로세스(매일 00시)
  : 판매 종료일이 도래한 상품의 상태값을 자동으로 비활성화 합니다.

    * 프로세스 정의
        * Read: 판매 종료일이 도래한 Product 엔티티를 조회합니다.
        * Process: Product 의 상태를 '판매중지' 로 변경합니다.
        * Write: 상품 변경사항을 로깅합니다.

### 테스트 

* H2
    * console: http://localhost:18080/h2-console
    * driverClass: org.h2.Driver 
    * jdbcUrl: jdbc:h2:mem:testdb
    * username: sa
    * password: 
