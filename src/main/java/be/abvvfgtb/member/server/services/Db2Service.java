package be.abvvfgtb.member.server.services;


import be.abvvfgtb.member.server.database.db2.domain.BaliFZZ;

/**
 * Member Service interface.
 */

public interface Db2Service {

    String SCHEMA_NAME_KEY = "spring.db2.datasource.default_schema_name";

    public BaliFZZ getMember(String firstName, String lastName);

}
