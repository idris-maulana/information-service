package com.idris.information.service;

import com.idris.information.common.CommonResponse;
import com.idris.information.model.Banner;
import com.idris.information.payloads.response.BannerResponse;
import com.idris.information.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BannerService {

    @Autowired
    BannerRepository bannerRepository;

    @Transactional
    public CommonResponse<?> getAllBanner() {
        List<Banner> bannerList = bannerRepository.findAll();
        List<BannerResponse> bannerResponses = new ArrayList<>();

        bannerList.forEach(bnr -> {
            bannerResponses.add(new BannerResponse(bnr.getBannerName(), bnr.getBannerImage(), bnr.getDescription()));
        });
        return new CommonResponse<>(0, "Sukses", bannerResponses);
    }
}
