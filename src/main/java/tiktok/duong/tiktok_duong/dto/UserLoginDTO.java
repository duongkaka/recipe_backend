package tiktok.duong.tiktok_duong.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
@Data
public class UserLoginDTO {
	
	    private Long id;

	   
	    private String username;

	   
	    private String password;

	   
	    private String role;
}
