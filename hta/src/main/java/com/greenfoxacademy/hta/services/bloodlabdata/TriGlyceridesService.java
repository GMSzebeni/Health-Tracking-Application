package com.greenfoxacademy.hta.services.bloodlabdata;

import com.greenfoxacademy.hta.models.bloodlabdata.BloodLabData;
import com.greenfoxacademy.hta.models.bloodlabdata.TriGlycerides;
import com.greenfoxacademy.hta.models.user.User;
import com.greenfoxacademy.hta.repositories.bloodlabdata.ITriGlyceridesRepository;
import com.greenfoxacademy.hta.services.user.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TriGlyceridesService implements ITriGlyceridesService {
    private final ITriGlyceridesRepository iTriGlyceridesRepository;
    private final IUserService iUserService;
    private final IBloodLabDataService iBloodLabDataService;

    @Override
    public void save(TriGlycerides triGlycerides, String email) {
        User user = iUserService.findByEmail(email);
        if (user.getBloodLabData() == null){
            BloodLabData bloodLabData = new BloodLabData();
            bloodLabData.setUser(user);
            user.setBloodLabData(bloodLabData);
        }
        BloodLabData bloodLabData = user.getBloodLabData();
        triGlycerides.setBloodLabData(bloodLabData);
        if (bloodLabData.getTriGlyceridesValues() == null){
            List<TriGlycerides> triGlyceridesValues = new ArrayList<>();
            bloodLabData.setTriGlyceridesValues(triGlyceridesValues);
            iBloodLabDataService.save(bloodLabData);
        }
        List<TriGlycerides> triGlyceridesValues = bloodLabData.getTriGlyceridesValues();
        triGlyceridesValues.add(triGlycerides);
        iTriGlyceridesRepository.save(triGlycerides);
        iBloodLabDataService.save(bloodLabData);
    }
}
