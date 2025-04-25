package tiktok.duong.tiktok_duong.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tiktok_users",schema = "recipe")
@Data
public class TikTokUser {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "first_name", length = 100)
	    private String firstName;

	    @Column(name = "last_name", length = 100)
	    private String lastName;

	    @Column(name = "full_name", length = 200)
	    private String fullName;

	    @Column(length = 100)
	    private String nickname;

	    @Column(columnDefinition = "TEXT")
	    private String avatar;

	    @Column(columnDefinition = "TEXT")
	    private String bio;

	    @Column(nullable = false)
	    private boolean tick = false;

	    @Column(name = "followings_count")
	    private Integer followingsCount = 0;

	    @Column(name = "followers_count")
	    private Integer followersCount = 0;

	    @Column(name = "likes_count")
	    private Integer likesCount = 0;

	    @Column(name = "website_url", columnDefinition = "TEXT")
	    private String websiteUrl;

	    @Column(name = "facebook_url", columnDefinition = "TEXT")
	    private String facebookUrl;

	    @Column(name = "youtube_url", columnDefinition = "TEXT")
	    private String youtubeUrl;

	    @Column(name = "twitter_url", columnDefinition = "TEXT")
	    private String twitterUrl;

	    @Column(name = "instagram_url", columnDefinition = "TEXT")
	    private String instagramUrl;

	    @Column(name = "created_at")
	    private LocalDateTime createdAt;

	    @Column(name = "updated_at")
	    private LocalDateTime updatedAt;
}
