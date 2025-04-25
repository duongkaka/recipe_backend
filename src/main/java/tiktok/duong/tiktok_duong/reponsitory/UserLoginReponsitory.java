package tiktok.duong.tiktok_duong.reponsitory;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import tiktok.duong.tiktok_duong.entity.UserLogin;
@Controller
public interface UserLoginReponsitory extends JpaRepository<UserLogin, Long> {
   UserLogin findByUsername(String username);
}