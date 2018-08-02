package org.softuni.kayzerwatchesapi.repository;

import org.softuni.kayzerwatchesapi.domain.enitity.Watch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchRepository extends JpaRepository<Watch, String> {
    List<Watch> findAllByOrderByViewsDesc();
}
