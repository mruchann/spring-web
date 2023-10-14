package yte.intern.springweb.model;

public record Post(
        Long userId,
        Long id,
        String title,
        String body
) {

}
