package pe.oh29oh29.ourlunch.domain.company;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.oh29oh29.ourlunch.domain.family.dto.RequestDTO;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public Company addCompany(RequestDTO.FamilyCreationRequest request) {
        Company company = new Company(request.getCompanyName());
        return companyRepository.save(company);
    }

}
