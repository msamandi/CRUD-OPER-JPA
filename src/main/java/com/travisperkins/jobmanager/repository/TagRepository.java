package com.travisperkins.jobmanager.repository;

import com.travisperkins.jobmanager.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by sverma on 01/03/2017.
 */
public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query(value = "SELECT t from Tag t where t.name=:tagName")
    Tag getTag(@Param("tagName")String tagName);

}
