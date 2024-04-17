/**
 *  Spring Component 사용을 위해 의존성 추가
 *  Domain Module, Spring 의존성 X 희망 시 -> API 모듈에서 Spring Bean 관리 작업 수행
 */
dependencies {
    compileOnly("org.springframework:spring-context")
}
