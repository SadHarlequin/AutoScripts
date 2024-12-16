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
public class DeletingDBController {
    @GetMapping("/deleteDBSQL")
    public String deleteDBSQL() {
        return "deleteDBSQL";
    }
    @PostMapping("/downloadDeletingDBScript")
    public ResponseEntity<byte[]> downloadDeletingDBScript(@RequestParam String dbname,
                                                           @RequestParam String u,
                                                           @RequestParam String dbUniqueName) {
        String content = "rm -rf /oracle/u01/admin/" + dbname +'\n' +"rm -rf oracle/u01/diag/"+ dbUniqueName+'\n'+"rm -rf /oracle/" +u+"/oradata/"+dbname;
        byte[] bytes = content.getBytes();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=DeletingDBScript.txt");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.TEXT_PLAIN)
                .body(bytes);
    }
}

