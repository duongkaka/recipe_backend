package tiktok.duong.tiktok_duong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tiktok.duong.tiktok_duong.entity.TikTokUser;
import tiktok.duong.tiktok_duong.reponsitory.TikTokUserRepository;
@Service
public class TiktokUserService {
	@Autowired
	TikTokUserRepository userRepository;

	public List<TikTokUser> searchUsersByName(String name) {
	    return userRepository.searchByNickname(name);
	}
}
