package com.dclm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dclm.model.Denomination;

@Repository
public interface DenominationRepository extends JpaRepository<Denomination, Integer> {

}
