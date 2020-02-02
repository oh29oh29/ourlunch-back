package pe.oh29oh29.ourlunch.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.oh29oh29.ourlunch.domain.family.Family;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {
    List<Member> findAllByFamily(Family family);
}
