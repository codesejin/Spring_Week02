package com.sprata.week02.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass // 상속했을 때, 컬럼으로 인식하게 합니다.
@EntityListeners(AuditingEntityListener.class) // 생성/수정 시간을 자동으로 반영하도록 설정
// abstract의 뜻은 직접 구현 안되고 상속으로만 쓸 수 있다는 뜻
// new Timestamped();같은 객체 생성으로 사용 안되고,
// extends Timestamped로 만 쓸 수 있다는 의미
public abstract class Timestamped {
    // 골뱅이 붙은걸 annotation이라고 함 : 스프링에게 야~ 이런 역할있어라고 알려주는 친구
    @CreatedDate // 생성일자임을 나타냅니다.
    private LocalDateTime createdAt;

    @LastModifiedDate // 마지막 수정일자임을 나타냅니다.
    private LocalDateTime modifiedAt;
}