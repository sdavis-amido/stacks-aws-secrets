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

  @Value(value = "${stacks.aws.demo1}")
  private String demo1;

  @Value(value = "${stacks.aws.demo2}")
  private String demo2;

  @Value(value = "${stacks1}")
  private String stacks1;

  @Value(value = "${stacks2}")
  private String stacks2;

  @GetMapping
  public ResponseEntity<String> get() {
    return ResponseEntity.ok(showSecrets());
  }

  @PostConstruct
  public void loaded() {
    log.debug(showSecrets());
  }

  private String showSecrets() {
    return "Secrets -> " + demo1 + " " + demo2 + " " + stacks1 + " " + stacks2;
  }
}
