package be.abvvfgtb.member.server.services;


/**
 * Member Service interface.
 */

public interface Db2Service {

    String SCHEMA_NAME_KEY = "spring.db2.datasource.default_schema_name";

    public String getMember(String firstName, String lastName);

}
