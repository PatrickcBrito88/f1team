package br.com.gmtbtec.controller;

import br.com.gmtbtec.model.Person;
import br.com.gmtbtec.model.PersonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController("/")
public class PersonController {

    static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    @GetMapping
    public ResponseEntity<String> view(){
        return new ResponseEntity<String>("Run Service Success", HttpStatus.OK);
    }

    @PostMapping(path = "/person", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponse> salvarPerson (@RequestBody Person person){
        LOGGER.info("Request : " + person.toString());
        PersonResponse personResponse = PersonResponse.builder()
                .id("1")
                .status(HttpStatus.CREATED)
                .menssage("Salvo com sucesso!")
                .build();
        return new ResponseEntity<PersonResponse>(personResponse, HttpStatus.CREATED);
    }

}
