package com.therealdanvega.mtom.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(exclude="posts")
public class Category {

    @Id @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    // you could also use: @JsonIgnoreProperties("categories")
    @JsonBackReference
    @ManyToMany( mappedBy = "categories" )
    private Set<Post> posts = new HashSet<>();

    public Category(String name) {
        this.name = name;
    }
}
