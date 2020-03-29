package pe.oh29oh29.ourlunch.domain.family;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FamilyRepository extends JpaRepository<Family, Long> {

    Optional<Family> findByName(String name);

    Optional<Family> findByCode(String code);

}
