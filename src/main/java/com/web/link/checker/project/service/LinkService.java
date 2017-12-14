package com.web.link.checker.project.service;

import com.web.link.checker.project.model.Link;
import com.web.link.checker.project.repository.LinkRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LinkService {

    @NonNull
    public final LinkRepository linkRepository;

    public List<Link> findAll() {
        return linkRepository.findAll();
    }
}
