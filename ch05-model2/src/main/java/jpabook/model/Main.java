package jpabook.model;

import jpabook.model.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {

            tx.begin(); //트랜잭션 시작

            logic(em);

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
        Member member = new Member();
        member.setName("Kim");
        em.persist(member);

        Item item = new Item();
        item.setName("Item1");
        item.setPrice(1000);
        em.persist(item);

        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setCount(1);
        orderItem.setOrderPrice(1000);
        em.persist(orderItem);

        Order order = new Order();
        order.setMember(member);
        order.setStatus(OrderStatus.ORDER);
        order.getOrderItems().add(orderItem);

        member.getOrders().add(order);

        em.persist(order);

        orderItem.setOrder(order);

    }
}
