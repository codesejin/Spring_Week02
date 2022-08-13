package com.sprata.week02;

import com.sprata.week02.domain.Course;
import com.sprata.week02.domain.CourseRepository;
import com.sprata.week02.domain.CourseRequestDto;
import com.sprata.week02.service.CourseService;
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


    @Bean
    public CommandLineRunner demo(CourseRepository courseRepository, CourseService courseService) {
        return (args) -> {
            //생성하고 insert하기
            courseRepository.save(new Course("프론트엔드의 꽃, 리액트", "임민영"));
            //조회하기
            System.out.println("데이터 인쇄");
            List<Course> courseList = courseRepository.findAll();
            for (int i=0; i<courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }
            //업데이트하기
            CourseRequestDto requestDto = new CourseRequestDto("웹개발의 봄, Spring", "임민영");
            courseService.update(1L, requestDto);
            courseList = courseRepository.findAll();
            for (int i=0; i<courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }
            // 삭제하기
            courseRepository.deleteAll();
        };
    }
}
