package crafter.spring_crafter;

import crafter.spring_crafter.domain.Member;
import crafter.spring_crafter.repository.JdbcMemberRepository;
import crafter.spring_crafter.repository.MemberRepository;
import crafter.spring_crafter.repository.MemoryMemberRepository;
import crafter.spring_crafter.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    // 멤버 서비스랑 멤버 레포지토리를 빈으로 연결
    // 오토와이어드 느낌으로
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
         // return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
