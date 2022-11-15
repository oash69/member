package be.abvvfgtb.member.server.controllers;



import be.abvvfgtb.member.server.database.db2.domain.BaliFZZ;
import be.abvvfgtb.member.server.services.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
@Service
public class MemberController implements IMemberController {


    @Autowired
    private IMemberService memberService;

    public BaliFZZ getMember(String firstName, String lastName) {
//        String firstName = request.getHeader("firstName");
//        String lastName = request.getHeader("lastName");
        //return String.format("Hi %s %s from Member Server! Your phone number is: %s", firstName, lastName, memberService.getMember(firstName, lastName));
        return memberService.getMember(firstName, lastName);
    }

    public void updatephonenumber(String id, String phone){
        memberService.updatephonenumber(id,phone);
    }
}