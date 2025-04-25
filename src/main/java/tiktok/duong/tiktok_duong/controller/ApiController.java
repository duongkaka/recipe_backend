package tiktok.duong.tiktok_duong.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tiktok.duong.tiktok_duong.dto.UserLoginDTO;
import tiktok.duong.tiktok_duong.entity.TikTokUser;
import tiktok.duong.tiktok_duong.service.TiktokUserService;
import tiktok.duong.tiktok_duong.service.UserLoginService;

@RestController
@CrossOrigin(origins = "http://localhost:3000") 
public class ApiController {
	@Autowired
	UserLoginService userLoginService;
	private List<String> dataStore = new ArrayList<>();
	
	@Autowired
	TiktokUserService userService;
	
	@GetMapping("/api/search")
	public List<TikTokUser> searchUsers(@RequestParam("name") String name) {
	    return userService.searchUsersByName(name);
	}

    // API mở: Lấy tất cả dữ liệu
    @GetMapping("/api/data")
//    @Secured("ROLE_ADMIN")
    public String getData() {
        return "HEllo";
    }
    
    @GetMapping("/admin/data")
    @Secured("ADMIN")
    public String getAdminData() {
        return "HEllo Amin";
    }

    // API đóng: Thêm dữ liệu vào dataStore
    @PostMapping("/api/data")
    public String addData(@RequestBody String newData) {
        dataStore.add(newData);
        return "Data added successfully!";
    }
    
    @PostMapping("api/register")
    public String registerUser(@RequestBody UserLoginDTO loginDTO) {
    	userLoginService.create(loginDTO);
        return "User created successfully!";
    }

}
