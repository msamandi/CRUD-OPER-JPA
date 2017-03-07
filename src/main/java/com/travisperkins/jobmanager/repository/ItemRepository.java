package com.travisperkins.jobmanager.repository;

import com.travisperkins.jobmanager.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by sverma on 01/03/2017.
 */
public interface ItemRepository extends JpaRepository<Item, Long> {
    /*@Query(value = "SELECT * " +
            "FROM ITEM A " +
            "INNER JOIN (select C.ITEM_ID  from ITEM_TAG C " +
            "WHERE C.TAG_ID in (select D.ID from TAG D where D.NAME = :tagName)) B " +
            "ON A.ID=B.ITEM_ID")
    List<Item> getItems(@Param("tagName") String tagName);*/
}

