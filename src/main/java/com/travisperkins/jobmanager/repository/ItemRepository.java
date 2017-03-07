package com.travisperkins.jobmanager.repository;

import com.travisperkins.jobmanager.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sverma on 01/03/2017.
 */
public interface ItemRepository extends JpaRepository<Item, Long> {

}

