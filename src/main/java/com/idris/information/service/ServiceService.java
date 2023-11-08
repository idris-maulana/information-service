package com.idris.information.service;

import com.idris.information.common.CommonResponse;
import com.idris.information.payloads.response.ServiceResponse;
import com.idris.information.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceService {

    @Autowired
    ServiceRepository serviceRepository;

    @Transactional
    public CommonResponse<?> getAllService() {
        List<com.idris.information.model.Service> serviceList = serviceRepository.findAll();
        List<ServiceResponse> serviceResponses = new ArrayList<>();

        serviceList.forEach(svc -> {
            serviceResponses.add(new ServiceResponse(svc.getServiceCode(), svc.getServiceName(), svc.getServiceIcon(), svc.getServiceTarif()));
        });

        return new CommonResponse<>(0, "Sukses", serviceResponses);
    }
}
