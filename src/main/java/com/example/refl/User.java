package com.example.refl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Encrypted
public class User {

    List<String> lines;

    List<Integer> rules;

    Article article;

    @Encrypted
    String name;

    @Encrypted
    int age;

    List<Comment> comments;



}
