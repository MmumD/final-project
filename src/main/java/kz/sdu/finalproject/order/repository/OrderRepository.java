package kz.sdu.finalproject.order.repository;

import kz.sdu.finalproject.order.entity.OrderEntity;
import kz.sdu.finalproject.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findOrderEntitiesByUser(UserEntity user);

}
