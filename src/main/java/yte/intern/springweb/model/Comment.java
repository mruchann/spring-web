package yte.intern.springweb.model;

public record Comment(
        Long postId,
        Long id,
        String name,
        String email,
        String body
) {
}
