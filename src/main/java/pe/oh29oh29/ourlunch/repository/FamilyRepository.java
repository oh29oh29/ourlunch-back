package pe.oh29oh29.ourlunch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.oh29oh29.ourlunch.entity.Family;

@Repository
public interface FamilyRepository extends JpaRepository<Family, String> {
}
