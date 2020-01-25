package pe.oh29oh29.ourlunch.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.oh29oh29.ourlunch.domain.company.Company;
import pe.oh29oh29.ourlunch.domain.company.CompanyRepository;

@RequiredArgsConstructor

@Service
public class CompanyCommandService {

    private final CompanyRepository companyRepository;

    Company addCompany(final String name) {
        return companyRepository.save(new Company(name));
    }
}
