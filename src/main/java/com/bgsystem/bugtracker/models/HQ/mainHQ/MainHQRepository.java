package com.bgsystem.bugtracker.models.HQ.mainHQ;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface MainHQRepository extends JpaRepository<MainHQEntity, Long> {

    Set<MainHQEntity> findByName (String name);

}
