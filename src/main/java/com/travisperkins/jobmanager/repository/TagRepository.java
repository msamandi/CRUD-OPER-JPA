package com.travisperkins.jobmanager.repository;

import com.travisperkins.jobmanager.model.Tag;
import com.travisperkins.jobmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by sverma on 01/03/2017.
 */
public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query(value = "select * from TAG t where t.NAME=:tagName")
    List<Tag> getTag(@Param("tagName") String tagName);
}
