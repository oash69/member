package be.abvvfgtb.member.server.database.db2.dao;

import be.abvvfgtb.member.server.database.db2.domain.BaliFZZ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
   Retrieves FZZ Informations
 */
@Service
@Repository
@Transactional
public interface BaliFZZDAO extends JpaRepository<BaliFZZ, String> {

  @Query("select c from BaliFZZ c where trim(upper(c.firstName)) = trim(upper(:firstName)) and trim(upper(c.lastName)) = trim(upper(:lastName))")
  List<BaliFZZ> findGsmByFirstNameAndLastName(@Param("firstName") String firstname, @Param("lastName") String lastName);

}
