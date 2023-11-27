
# 데이터 중심 설계의 문제점
* example1의 방식은 객체 설계를 테이블 설계에 맞춘 방식이다.
  * Order에 MemberId가 존재하기 때문에, 객체를 바로 끄집어낼 수 없고, memberId를 통해 다시 조회해야 하기 때문이다.
  * 이와 같은 방식은 객체 지향 설계를 위반한다고 볼 수 있다.
* 테이블의 외래키를 객체에 그대로 가져온다.
* 객체 그래프 탐색이 불가능하다.
* 참조가 없으므로 UML도 잘못되었다.

```java
@Entity
@Getter
@Setter
@Table(name = "ORDERS")
public class Order {
    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    private String city;

    private String street;

    private String zipcode;
}

```
