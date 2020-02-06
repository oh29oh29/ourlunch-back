package pe.oh29oh29.ourlunch.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.oh29oh29.ourlunch.domain.company.Company;
import pe.oh29oh29.ourlunch.domain.company.CompanyRepository;

@RequiredArgsConstructor

@Service
public class CompanyQueryService {

    private final CompanyRepository companyRepository;

    public Company findByNameOrSave(final String name) {
        return companyRepository
                .findByName(name)
                .orElseGet(() -> companyRepository.save(new Company(name)));
    }

}
