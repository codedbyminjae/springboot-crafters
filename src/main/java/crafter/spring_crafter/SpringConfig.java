package crafter.spring_crafter;

import crafter.spring_crafter.domain.Member;
import crafter.spring_crafter.repository.MemberRepository;
import crafter.spring_crafter.repository.MemoryMemberRepository;
import crafter.spring_crafter.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    // 멤버 서비스랑 멤버 레포지토리를 빈으로 연결
    // 오토와이어드 느낌으로
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
