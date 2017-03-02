package com.travisperkins.jobmanager.repository;

import com.travisperkins.jobmanager.model.TPClient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sverma on 01/03/2017.
 */
public interface TPClientRepository extends JpaRepository<TPClient, Long> {

}
