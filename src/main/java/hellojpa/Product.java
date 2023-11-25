package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
public class Product {
    @Id @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "products")
    private List<MemberProduct> memberProducts = new ArrayList<>();
}
