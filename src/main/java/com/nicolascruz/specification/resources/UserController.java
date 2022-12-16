package com.nicolascruz.specification.resources;

import com.nicolascruz.specification.models.User;
import com.nicolascruz.specification.repositories.specification.SpecificationBuilder;
import com.nicolascruz.specification.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<List<User>> find(@RequestParam String search) {
        SpecificationBuilder builder = new SpecificationBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>|-|!-|>-|<-)(\"([^\"]+)\")", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3).replace("\"", ""));
        }
        return ResponseEntity.ok(userService.find(builder.getFilters()));
    }
}
