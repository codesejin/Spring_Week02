package com.sprata.week02;

import com.sprata.week02.domain.Course;
import com.sprata.week02.domain.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing //이걸 추가해줘야만 비로소 그 수정일자가 스프링을 통해 반영됨
@SpringBootApplication
public class Week02Application {

    public static void main(String[] args) {
        SpringApplication.run(Week02Application.class, args);
    }

    // Week02Application.java 의 main 함수 아래에 붙여주세요.
    @Bean
    public CommandLineRunner demo(CourseRepository repository) {
        return (args) -> {

            Course course1 = new Course("웹개발의봄 Spring", "박세진");
            repository.save(course1); // 이 한줄이면 create부터 insert까지 한방
            //코스 여러개가 순서대로 담겨져 온다 => 레포지토리가 select해서 전부다 courseList안에 있는걸 다 가져옴
            List<Course> courseList = repository.findAll(); // 조회하기
            for(int i = 0; i < courseList.size(); i++){
                Course c = courseList.get(i);
                System.out.println(c.getTitle());
                System.out.println(c.getTutor());
            }
        };
    }
}
