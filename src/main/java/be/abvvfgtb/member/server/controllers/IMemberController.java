package be.abvvfgtb.member.server.controllers;

import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

public interface IMemberController {

    String getMember(String firstName,  String lastName);

}
