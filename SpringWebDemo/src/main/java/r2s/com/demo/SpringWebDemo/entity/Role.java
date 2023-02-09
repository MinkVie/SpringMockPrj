package r2s.com.demo.SpringWebDemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ROLE")
public class Role {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ROLE_USER")
    private String roleUser;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;
}
