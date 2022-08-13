package com.sprata.week02.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
//arguenmts는 파라미터 재료
@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Entity // 그냥 클래스아니고, 데이터베이스 기준으로 테이블 역할 해주는 클래스
public class Course extends Timestamped {

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String title;

    @Column(nullable = false)
    private String tutor;
    //id는 데이터베이스에서 설정해주기에 게터/세터 ㄴㄴ
    // 나머지는 게터 만들어주고 세터는 ㄴㄴ
    // 세터는 레포지토리에서 알아서 해줄것임
    public String getTitle() {
        return this.title;
    }

    public String getTutor() {
        return this.tutor;
    }

    public Course(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }
}