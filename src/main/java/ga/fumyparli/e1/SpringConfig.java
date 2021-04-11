package ga.fumyparli.e1;

import ga.fumyparli.e1.repository.MemberRepository;
import ga.fumyparli.e1.repository.MemoryMemberRepository;
import ga.fumyparli.e1.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
