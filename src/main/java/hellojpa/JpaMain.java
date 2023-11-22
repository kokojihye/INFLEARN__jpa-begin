package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.List;

import static javax.persistence.Persistence.createEntityManagerFactory;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        //transaction begin
        tx.begin();

        try{
            //멤버 등록
            /*
            * Member member = new Member();
            * member.setId(2L);
            * member.setName("jihyeko");
            * em.persist(member);
            * */

            //멤버 조회
            /*
            * Member findMember = em.find(Member.class, 1L);
            * System.out.println("findMember.getId() = " + findMember.getId());
            * System.out.println("findMember.getName() = " + findMember.getName());
            * */

            //멤버 수정
            /*
            * Member findMember = em.find(Member.class, 1L);
            * findMember.setName("helloJPA");
            * */

            //JPQL
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(8)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }

            //비영속(new/transient)
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA!!!");

            //영속(managed)
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");

//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);

//            System.out.println("result = " + (findMember1 == findMember2));

//            Member member = em.find(Member.class, 101L);
            //member.setName("member101!!!");

//            System.out.println("====== BEFORE FLUSH =======");
//            em.flush();
//            System.out.println("====== AFTER FLUSH =======");
//
//            System.out.println("====== BEFORE COMMIT =======");

//            System.out.println("====== AFTER COMMIT =======");

            Member member = new Member();
            member.setId("ID_A");
            member.setUsername("jihye");

            em.persist(member);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
