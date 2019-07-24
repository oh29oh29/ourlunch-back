package pe.oh29oh29.ourlunch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pe.oh29oh29.ourlunch.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
}
