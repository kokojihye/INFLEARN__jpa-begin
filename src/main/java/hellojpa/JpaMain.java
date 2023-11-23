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
            Team team1 = new Team();
            team1.setName("Team A");
            em.persist(team1);

            Team team2 = new Team();
            team2.setName("Team A");
            em.persist(team2);

            Member member = new Member();
            member.setName("member1");
            member.setTeam(team1);
            em.persist(member);


            System.out.println("===============");
            em.flush();
            em.clear();
            System.out.println("===============");

            Member findMember = em.find(Member.class, member.getId());
            Team findTeam = findMember.getTeam();

            System.out.println("findTeam = " + findTeam.getName());

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
