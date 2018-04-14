package com.damerla.trattor.service;

import com.damerla.trattor.model.CompanyModel;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public interface ISuperAdminService {
    /**
     * <p>Save Company Entity </p>
     *
     * @param companyModel
     * @return {@code boolean}
     */
    boolean saveCompany(CompanyModel companyModel);
}
