package be.abvvfgtb.member.server.controllers;

import be.abvvfgtb.member.server.database.db2.domain.BaliFZZ;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

public interface IMemberController {

    BaliFZZ getMember(String firstName, String lastName);
    public void updatephonenumber(String id, String phone);
}
