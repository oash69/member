package be.abvvfgtb.member.server.services;

import be.abvvfgtb.member.server.database.Db2MultiTenantResolver;
import be.abvvfgtb.member.server.database.db2.dao.BaliFZZDAO;
import be.abvvfgtb.member.server.database.db2.domain.BaliFZZ;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * DB2 Service Implementation.
 */
@Service
@Profile({"local", "!xxlocal"})
public class MemberService implements IMemberService, Db2Service{

    @Autowired
    private Environment env;

    private String schemaPrefix;
    private String nationalSchemaPrefix;
    private boolean isProdEnv = false;

    @Autowired
    BaliFZZDAO baliFzz;

    /**
     * DB2 Service Implementation constructor.
     *
     * @param env environment file
     */
    @Autowired
    public MemberService(Environment env) {
        this.env = env;
        this.schemaPrefix = env.getProperty(SCHEMA_NAME_KEY,
                String.class,
                Db2MultiTenantResolver.DEFAULT_SCHEMA_PREFIX);
        this.nationalSchemaPrefix = env.getProperty("spring.db2.national.datasource.default_schema_name",
                String.class);


        this.isProdEnv = Arrays.asList(this.env.getActiveProfiles()).contains("prod");
    }

    public String getMember(String firstName, String lastName) {
        Db2MultiTenantResolver.setTenant(
                this.schemaPrefix
                        + Db2MultiTenantResolver.DEFAULT_TENANT_IDENTIFIER);

        List<BaliFZZ> baliFUSOptional = baliFzz.findGsmByFirstNameAndLastName(firstName, lastName);
        if(!baliFUSOptional.isEmpty()) {
            BaliFZZ baliFzz = baliFUSOptional.get(0);
            if(!StringUtils.isBlank(baliFzz.getGsmNumber()))
            return baliFzz.getGsmNumber();
        }
        return "No Gsm Number Found!";
    }

}
