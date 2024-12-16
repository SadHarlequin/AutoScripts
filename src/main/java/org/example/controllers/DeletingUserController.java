package org.example.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;
@Controller
public class DeletingUserController {
    @GetMapping("/deleteUserSQL")
    public String deleteUserSQL() {
        return "deleteUserSQL"; // имя шаблона
    }
    @PostMapping("/downloadDeletingScript")
    public ResponseEntity<byte[]> downloadDeletingScript(@RequestParam String username) {
        String content = "ucb.user " + username + " was deleted";
        byte[] bytes = content.getBytes();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=DeletingScript.txt");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.TEXT_PLAIN)
                .body(bytes);
    }
}
