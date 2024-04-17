 ### Module Settings 

 1. API
    - API 통신을 위한 모듈입니다. Connection Pool 할당 기준으로 모듈을 설정하는 과정에서 내부 하위 모듈을 Internal과 External로 구분했지만 요구사항을 통한 코드 작성 시 기본 RestTemplate 객체를 사용해도 된다고 판단해 Coonection Pool을 할당받지 않아 별도의 모듈 분리를 하지 않았습니다.
   
      Domain Module, Spring Web : Implementation
       
      infra > mysql Module : RuntimeOnly  
   
2. Domain
    - 도메인 모듈로 Domain,Repository,Service 레이어가 존재한다. 현재 구조 상, 도메인 모듈이 비즈니스 책임까지 가지고 있지만, 현재의 요구 사항으로는 비즈니스 계층은 단순 위임 작업만 수행한다고 판단하여 포함시켰습니다.
      Repository 는 Interface로 설게하였으며, 구현 클래스는 Infra Module에 존재하게 설계했습니다.  

      spring-context : compileOnly  

3. Infra
    - Database, Server Infra 계층입니다. 외부 Module로부터 Entity 보호가 가능하며, Domain Module Repository Interface구현체가 존재하며 Entity는 요구 사항 지역과 API ResponseData를 저장할 수 있는 단일 테이블로 설계했습니다.
      이후, 하위 모듈을 구성하여 Database 변경 및 Server Infra 변경 시 Infra 모듈만 수정하여 동작하게 할 수 있습니다.
      


      Domain Module : compileOnly
      
      Spring JPA : implementation

      mysql-connector : runtimeOnly



 ### API Test 

 ![빅스 테스트 1](https://github.com/lsh96900410/solo/assets/133841235/e69fe637-22c8-4644-8e75-cab4a6bb6d6a)
 ![빅스 테스트 2](https://github.com/lsh96900410/solo/assets/133841235/c7722e31-b0b2-4110-af8d-7747b495255f)

 
 


