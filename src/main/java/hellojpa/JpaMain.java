package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.time.LocalDateTime;
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
            Member member = new Member();
            member.setName("user1");
            member.setCreatedBy("kim");
            member.setCreatedDate(LocalDateTime.now());

            em.persist(member);

            em.flush();
            em.clear();

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
