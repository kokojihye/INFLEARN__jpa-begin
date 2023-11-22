package hellojpa;

import lombok.*;
import java.util.*;
import javax.persistence.*;
@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table
public class Member {

    @Id @GeneratedValue
    private String id;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(100) default 'EMPTY'")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    @Transient
    private int temp;
}
