package com.sprata.week02.service;

import com.sprata.week02.domain.Course;
import com.sprata.week02.domain.CourseRepository;
import com.sprata.week02.domain.CourseRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service // 스프링에게 이 클래스는 서비스임을 명시 : sql같이 업데이트하는 작용이 일어날수있으니 알아둬~
public class CourseService {

    // final: 서비스에게 꼭 필요한 녀석임을 명시 / 검색&업데이트할때도 sql날려야하니까 리포지토리 필요
    // final은  꼭 필요한거야~ 라고 알려줌 ,한번 그 값이 부여되면 변형될 수가 없다
    private final CourseRepository courseRepository;

    // 이 밑으로 주의해야 하는 부분(업데이트)
    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    //2개 매개변수 필요 : 업데이트 되면 어떤 놈이 업데이트됬는지(id)알려주고, 업데이트할 정보를 가지고 올 놈 필요
    public Long update(Long id, CourseRequestDto requestDto) {
        //  id가 1이라면 해당 데이터를 course1에 집어넣어주고
        Course course1 = courseRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        //그 상태에서 course1이 업데이트 되도록 메소드 설정하면
        // 전달받은 정보가 아래 파라미터 즉정보로 넘어간다
        course1.update(requestDto);
        //업데이트한 id를 보여줘라
        return course1.getId();
    }
}
