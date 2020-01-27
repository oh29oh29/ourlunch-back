package pe.oh29oh29.ourlunch.domain.company;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, String> {

    Optional<Company> findByName(final String name);
}
