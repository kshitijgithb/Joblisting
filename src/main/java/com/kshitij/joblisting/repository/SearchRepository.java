package com.kshitij.joblisting.repository;

import com.kshitij.joblisting.model.Post;

import java.util.List;

public interface SearchRepository {
    List<Post>findByText(String text);
}
