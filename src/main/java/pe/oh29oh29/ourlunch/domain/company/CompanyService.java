package pe.oh29oh29.ourlunch.domain.company;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public Company addCompany(final String name) {

        return companyRepository.save(Company.of(name));
    }

    public Company findByName(final String name) {

        return companyRepository.findByName(name);
    }
}
