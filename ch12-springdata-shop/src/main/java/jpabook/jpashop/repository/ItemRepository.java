package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * User: HolyEyE
 * Date: 2013. 12. 3. Time: 오후 9:48
 */
public interface ItemRepository extends JpaRepository<Item, Long> {

//public interface ItemRepository extends JpaRepository<Item, Long> , QueryDslPredicateExecutor<Item> {
//    는 편리하게 QueryDSL을 사용할 수 있지만 기능에 한계가 있다 -> join, fetch 사용 불가
//    JPAQuery를 직접 사용하거나 스프링 데이터 JPA가 제공하는 QueryDslRepositorySupport를 사용해야 한다
//    -> CustomOrderRepository 이용
}
