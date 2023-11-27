package hellojpa;

import lombok.*;
import java.util.*;
import javax.persistence.*;
@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table
public class Member extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="USERFNAME")
    private String name;

//    @Column(name="TEAM_ID")
//    private Long teamId;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;
}
