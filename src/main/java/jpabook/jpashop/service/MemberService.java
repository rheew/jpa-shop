package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;

    public Long join(Member member) {
        validationMember(member);
        return repository.save(member).getId();
    }

    private void validationMember(Member member) {
        final List<Member> members = repository.findByName(member.getName());

        if (members.size() > 0) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<Member> findMembers() {
        return repository.findAll();
    }

    public Member findOne(Long id) {
        return repository.findOne(id);
    }
}
