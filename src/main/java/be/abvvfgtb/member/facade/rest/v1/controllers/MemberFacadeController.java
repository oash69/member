package be.abvvfgtb.member.facade.rest.v1.controllers;


import be.abvvfgtb.bali.domain.BaliResultDto;
import be.abvvfgtb.bali.domain.MessageResponseDto;
import be.abvvfgtb.member.server.controllers.MemberController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/v1")
@RestController
public class MemberFacadeController implements IMemberFacadeController {

    @Bean
    public RestTemplate restTemplateFacade() {
        return new RestTemplate();
    }

    @Autowired
    MemberController memberController;

  /*  @GetMapping("/memberFacade")
    public ResponseEntity<BaliResultDto> getMember(@RequestParam(value = "firstName") String firstName,
                                                   @RequestParam(value = "lastName") String lastName,
                                                   HttpServletRequest request) {
        HttpHeaders headers = IMemberFacadeController.createHeaders("admin", "admin");
        headers.set("firstName", firstName);
        headers.set("lastName", lastName);

        UriComponents builder = UriComponentsBuilder.fromHttpUrl(memberUrl)
                .queryParam("firstName",firstName)
                .queryParam("lastName",lastName)
                .build();

        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

        ResponseEntity<String> body = restTemplateFacade().exchange(builder.toUriString(),
                HttpMethod.GET,
                requestEntity,
                String.class);


        return ResponseEntity.ok(new BaliResultDto()
                .messageResponse(new MessageResponseDto()
                        .message(String.format("Hello %s %s from Member Facade Server: '%s'", firstName, lastName, body.getBody()))));

        return memberController.getMember(firstName,lastName);

    }*/
  @GetMapping("/memberFacade")
  public String getMember(@RequestParam(value = "firstName") String firstName,
                                                 @RequestParam(value = "lastName") String lastName,
                                                 HttpServletRequest request) {

      return memberController.getMember(firstName,lastName);

  }

/*    @ResponseBody
    @GetMapping("/memberFacadeSignaletique")
    public String getMemberSignaletique(@RequestParam(value = "firstName") String firstName,
                                                   @RequestParam(value = "lastName") String lastName,
                                                   HttpServletRequest request) {
        HttpHeaders headers = IMemberFacadeController.createHeaders("admin", "admin");
        headers.set("firstName", firstName);
        headers.set("lastName", lastName);

        UriComponents builder = UriComponentsBuilder.fromHttpUrl(memberUrl)
                .queryParam("firstName",firstName)
                .queryParam("lastName",lastName)
                .build();

        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

        ResponseEntity<String> body = restTemplateFacade().exchange(builder.toUriString(),
                HttpMethod.GET,
                requestEntity,
                String.class);

        String html = "Nom " + lastName +" </br>";
        html += "Prenom " + firstName +" </br>";
        html += "Téléphone " + body.getBody() +" </br>";
        return html;
    }*/

}