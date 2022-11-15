package be.abvvfgtb.member.server.services;

import be.abvvfgtb.member.server.database.db2.domain.BaliFZZ;
import org.springframework.stereotype.Service;

@Service
public interface IMemberService {

    public BaliFZZ getMember(String firstName, String lastName);
    public void updatephonenumber(String id, String phone);

}
