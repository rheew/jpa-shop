package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired private MemberService service;
    @Autowired private MemberRepository repository;

    @Test
    void 회원가입() {

        Member member = new Member();
        member.setName("testName");

        final Long memberId = service.join(member);

        assertThat(memberId).isEqualTo(member.getId());
    }

    @Test
    void 중복회원_예외발생() {

        Member member1 = new Member();
        Member member2 = new Member();

        member1.setName("test");
        member2.setName("test");

        service.join(member1);

        assertThatThrownBy(() -> service.join(member2))
                .isInstanceOf(IllegalStateException.class);
    }
}
