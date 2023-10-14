package yte.intern.springweb;
import org.springframework.http.ResponseEntity;
import yte.intern.springweb.model.Comment;
import yte.intern.springweb.model.Post;

import org.junit.jupiter.api.Test;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

public class JsonPlaceholderTest {

    RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @Test
    public void getPosts() {
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();

        ResponseEntity<Post[]> response = restTemplate.exchange(requestEntity, Post[].class);
        List<Post> posts = Arrays.stream(response.getBody()).toList();
        System.out.println(posts);
    }

    @Test
    public void getSinglePost() {
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts", "2")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();

        ResponseEntity<Post> response = restTemplate.exchange(requestEntity, Post.class);
        Post post = response.getBody();
        System.out.println(post);
    }

    @Test
    public void addPost() {
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .build()
                .toUri();

        Post post = new Post(1L,1L,"Title", "Body");

        RequestEntity<Post> requestEntity = RequestEntity.post(uri).body(post);

        ResponseEntity<Post> response = restTemplate.exchange(requestEntity, Post.class);
        System.out.println(response.getBody());
    }

    @Test
    public void getPostById() {
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .queryParam("userId", "2")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();

        ResponseEntity<Post[]> response = restTemplate.exchange(requestEntity, Post[].class);
        List<Post> posts = Arrays.stream(response.getBody()).toList();
        System.out.println(posts);
    }

    @Test
    public void updateComment() {
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("comments", "5")
                .build()
                .toUri();

        Comment comment = new Comment(1L, 1L, "Rüçhan", "ruchan.yavuzdemir@tubitak.com", "First comment!!!");

        RequestEntity<Comment> requestEntity = RequestEntity.put(uri).body(comment);

        ResponseEntity<Comment> response = restTemplate.exchange(requestEntity, Comment.class);
        System.out.println(response.getBody());
    }

    @Test
    public void deletePostById() {
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts", "7")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.delete(uri).build();

        ResponseEntity<Post> response = restTemplate.exchange(requestEntity, Post.class);
        System.out.println(response.getBody());
    }
}