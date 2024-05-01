package kz.sdu.finalproject.cards.repository;

import kz.sdu.finalproject.cards.entity.CardEntity;
import kz.sdu.finalproject.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CardRepository extends JpaRepository<CardEntity, Long> {

    Optional<CardEntity> findCardEntitiesByUser(UserEntity user);

}
