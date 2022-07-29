package com.amido.demo.awssecrets.controller;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/test")
@RestController
public class TestController {

  @Value(value = "${stacks-secret-1:secret-not-available}")
  private String secret1;

  @Value(value = "${stacks-secret-2:secret-not-available}")
  private String secret2;

  @Value(value = "${stacks-secret-3:secret-not-available}")
  private String secret3;

  @Value(value = "${stacks-secret-4:secret-not-available}")
  private String secret4;

  @GetMapping
  public ResponseEntity<String> get() {
    return ResponseEntity.ok(showSecrets());
  }

  @PostConstruct
  public void loaded() {
    log.debug(showSecrets());
  }

  public String getSecrets() {

    log.info("Getting some secrets...");

    return showSecrets();
  }

  private String showSecrets() {
    return "Secrets -> " + secret1 + ", " + secret2 + ", " + secret3 + ", " + secret4;
  }
}
