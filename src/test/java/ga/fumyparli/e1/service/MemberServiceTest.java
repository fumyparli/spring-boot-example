package ga.fumyparli.e1.service;

import ga.fumyparli.e1.domain.Member;
import ga.fumyparli.e1.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemoryMemberRepository memberRepository;
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입_테스트() {
        //given
        Member member = new Member();
        member.setName("seungbeom");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        System.out.println(memberService.findOne(saveId));
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 회원가입_중복제거_테스트() {
        //given
        Member member1 = new Member();
        member1.setName("seungbeom");

        Member member2 = new Member();
        member2.setName("seungbeom");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        //then
    }

    @Test
    void findOne() {
    }
}