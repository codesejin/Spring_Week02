package com.sprata.week02.domain;

import org.springframework.data.jpa.repository.JpaRepository;

//코스에 관한 레포지토리 (레포지토리:sql역할)
//extends 상속: 뒤에 있는 녀석의 다른 기능을 내가 가져와서 이용한다
// 코스안에 id의 형타입은 롱이다
// jpa는 인터페이스를 통해서만 사용 가능하다
// 인터페이스 :  jpa사용하는 방법 / 클래스에서 멤버가빠진, 메소드 모음집
public interface CourseRepository extends JpaRepository<Course, Long> {
}
