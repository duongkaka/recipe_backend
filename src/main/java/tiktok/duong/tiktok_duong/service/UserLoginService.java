package tiktok.duong.tiktok_duong.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tiktok.duong.tiktok_duong.dto.UserLoginDTO;
import tiktok.duong.tiktok_duong.entity.UserLogin;
import tiktok.duong.tiktok_duong.reponsitory.UserLoginReponsitory;

@Service
public class UserLoginService implements UserDetailsService {

	@Autowired
	UserLoginReponsitory loginReponsitory;

	public Optional<UserLoginDTO> getUser() {
		return null;
	}

	@Transactional
	public void create(UserLoginDTO loginDTO) {
		UserLogin userLogin = new ModelMapper().map(loginDTO, UserLogin.class);
		userLogin.setPassword(new BCryptPasswordEncoder().encode(userLogin.getPassword()));

		loginReponsitory.save(userLogin);
	}

	@Transactional
	public void updatePassword(UserLoginDTO loginDTO) {
		UserLogin currentUser = loginReponsitory.findByUsername(loginDTO.getUsername());
		if (currentUser != null) {
			currentUser.setPassword(new BCryptPasswordEncoder().encode(loginDTO.getPassword()));

			loginReponsitory.save(currentUser);
		}
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserLogin userLogin = loginReponsitory.findByUsername(username);
		if (userLogin == null) {
			throw new UsernameNotFoundException(username);
		}
		// convert user -> userdetails]
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		String role = userLogin.getRole();
		authorities.add(new SimpleGrantedAuthority(role));

		return new User(username, userLogin.getPassword(), authorities);
	}

}
