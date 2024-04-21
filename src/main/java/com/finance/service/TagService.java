package com.finance.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.finance.dtos.TagCreateDto;
import com.finance.model.Account;
import com.finance.model.Tag;
import com.finance.repository.AccountRepository;
import com.finance.repository.TagRepository;

@Service
public class TagService {
    private final TagRepository tagRepository;
    private final AccountRepository accountRepository;
    

    public TagService(TagRepository tagRepository, AccountRepository accountRepository) {
        this.tagRepository = tagRepository;
        this.accountRepository = accountRepository;
    }

    public List<Tag> allTags() {
        List<Tag> tags = new ArrayList<Tag>();

        tagRepository.findAll().forEach(tags::add);

        return tags;
    }

    public List<Tag> getTags(Integer account) {

        Account acc = accountRepository.findById(account).orElse(null);


        List<Tag> tags = tagRepository.findByAccount(acc);

        return tags;
    }

    public Tag createTag(TagCreateDto account) {

        Tag acc = new Tag();

        accountRepository.findById(account.getAccount()).ifPresent(acc::setAccount);

        acc.setDescription(account.getDescription());
        acc.setName(account.getName());


        return tagRepository.save(acc);
    }
}

