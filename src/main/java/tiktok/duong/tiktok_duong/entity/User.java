package tiktok.duong.tiktok_duong.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "m_user", schema = "tiktok")  // Chỉ định bảng và schema
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto increment cho cột id
    private int id;

    private String name;

    private int age;

    @Column(name = "username", unique = true)  // Cột "username" với unique constraint
    private String username;

    private String password;

    private String role;  // Vaitro

    private String gender;  // Gioitinh

    private String image;  // URL anh
}
