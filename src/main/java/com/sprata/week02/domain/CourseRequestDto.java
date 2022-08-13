package com.sprata.week02.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
// Course에 대한 데이터를 물고다니는 녀석
public class CourseRequestDto {
    private String title;
    private String tutor;
}
