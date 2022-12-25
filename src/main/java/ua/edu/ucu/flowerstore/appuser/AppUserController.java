package ua.edu.ucu.flowerstore.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class AppUserController {
    private AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService){
        this.appUserService = appUserService;
    }
    @GetMapping
    public List<AppUser> getAppUsers(){
        return appUserService.getAppUsers();
    }

    @PostMapping
    public void addUser(@RequestBody AppUser appUser){
        appUserService.addUser(appUser);
    }
}
