package crafter.spring_crafter.repository;

import crafter.domain.Member;
import crafter.repository.MemberRepository;
import crafter.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 테스트가 끝날 때마다 레포지토리를 초기화
    // 테스트 마다 서로간의 의존성이 생기면 안된다. 순서에 상관없이 모든 TC를 통과해야 한다.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("test");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
        // Assertions.assertEquals(member, result); // 테스트 케이스 작성시 수행해서 번거로운 확인을 줄여줌
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result).hasSize(2);
    }
}
