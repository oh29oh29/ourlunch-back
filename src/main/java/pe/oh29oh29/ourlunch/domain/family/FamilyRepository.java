package pe.oh29oh29.ourlunch.domain.family;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<Family, Long> {
    Family findByName(String familyName);
}
