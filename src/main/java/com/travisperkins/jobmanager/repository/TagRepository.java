package com.travisperkins.jobmanager.repository;

import com.travisperkins.jobmanager.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by sverma on 01/03/2017.
 */
public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query(value = "SELECT t from Tag t where name=:tagName")
    List<Tag> getTags(@Param("tagName")String tagName);

    @Query(value = "SELECT t from Tag t where name=:tagName")
    Tag getTag(@Param("tagName")String tagName);

}
