package r2s.com.demo.SpringWebDemo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "USER_INFO")
public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<SimpleGrantedAuthority> roles;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<Address> addresses;

    public User(String username, String password, List<SimpleGrantedAuthority> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public User() {

    }
}
