package com.finance.routes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finance.dtos.TagCreateDto;
import com.finance.model.Tag;
import com.finance.service.TagService;

import java.util.List;

@RequestMapping("/tag")
@RestController
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/tags")
    public ResponseEntity<List<Tag>> getTags(@RequestParam("account") Integer accountId){
        // get from query the account id


        List<Tag> tags = tagService.getTags(accountId);

        return ResponseEntity.ok(tags);

    }

    @PostMapping("/create")
    public ResponseEntity<Tag> createAccount(@RequestBody TagCreateDto tag) {
        Tag createdTag = tagService.createTag(tag);

        return ResponseEntity.ok(createdTag);
    }
}
