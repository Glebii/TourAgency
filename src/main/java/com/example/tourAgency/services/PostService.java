package com.example.tourAgency.services;

import com.example.tourAgency.models.Post;
import com.example.tourAgency.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public List<Post> postList(){

        return postRepository.findAll();
    }
    public void creatPost(Post post) {
        postRepository.save(post);
    }
    public void deletePost(Long id){

        postRepository.deleteById(id);
    }
    public Post updateById(Long id){
        return postRepository.findById(id).get();
    }
}
