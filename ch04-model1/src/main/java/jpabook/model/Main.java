package jpabook.model;

import jpabook.model.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {

            tx.begin(); //트랜잭션 시작
            Member member = memberLogic(em);

            orderLogic(em, member);

            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close();
    }
    private static void logic(EntityManager em){

    }
    private static Member memberLogic(EntityManager em){
        Member member = new Member();

        member.setName("Kim");
        member.setCity("Seoul");
        member.setStreet("Tehran-ro");
        member.setZipcode("12345");

        em.persist(member);

        return member;
    }

    private static void orderLogic(EntityManager em, Member m){
        Item a = new Item();
        a.setName("a");

        em.persist(a);

        Order o = new Order();
        o.setMemberId(m.getId());
        o.setOrderDate(new Date());
        o.setStatus(OrderStatus.ORDER);

        em.persist(o);

        OrderItem oi = new OrderItem();
        oi.setItemId(a.getId());
        oi.setOrderId(o.getId());
        oi.setOrderPrice(1);
        oi.setCount(1);

        em.persist(oi);
    }
}
