package be.abvvfgtb.member.server.database.db2.dao;

import be.abvvfgtb.member.server.database.db2.domain.BaliFUS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Repository
@Transactional
/*
   Retrieves Fus Informations
 */
public interface BaliFUSDAO extends JpaRepository<BaliFUS, String> {

  @Query("select c from BaliFUS c where trim(upper(c.systemUsername)) = trim(upper(:username))")
  Optional<BaliFUS> findFusByUsername(@Param("username") String username);

}
