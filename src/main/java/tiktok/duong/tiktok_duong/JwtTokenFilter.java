package tiktok.duong.tiktok_duong;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import tiktok.duong.tiktok_duong.service.JwtService;
@Component
@Slf4j
public class JwtTokenFilter 
//extends OncePerRequestFilter
{

	@Autowired
	JwtService jwtService;
	
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		// doc header
//		String bearerToken = request.getHeader("Authorization");
//		log.info("co token hay k"+bearerToken);
//		if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
//			String token = bearerToken.substring(7);
//		}
//	}
}
