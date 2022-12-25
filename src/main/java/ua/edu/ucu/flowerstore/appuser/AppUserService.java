package ua.edu.ucu.flowerstore.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {
    private AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> getAppUsers() {
        return appUserRepository.findAll();
    }

    public void addUser(AppUser appUser) {
        // check whether user exists
        if(appUserRepository.findAppUserByEmail(appUser.getEmail()).isEmpty()){
            appUserRepository.save(appUser);
        }

    }
}
