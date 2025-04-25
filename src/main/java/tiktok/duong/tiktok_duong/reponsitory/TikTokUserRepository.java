package tiktok.duong.tiktok_duong.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tiktok.duong.tiktok_duong.entity.TikTokUser;
@Repository
public interface TikTokUserRepository extends JpaRepository<TikTokUser, Long>{
	@Query("SELECT u FROM TikTokUser u WHERE LOWER(u.nickname) LIKE LOWER(CONCAT('%', :nickname, '%'))")
	List<TikTokUser> searchByNickname(@Param("nickname") String nickname);
}
