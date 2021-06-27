package com.repos;

import com.models.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface ZoneRepo extends JpaRepository<Zone, String> {
    @Override
    @Modifying
    <S extends Zone> S save(S s);
}
