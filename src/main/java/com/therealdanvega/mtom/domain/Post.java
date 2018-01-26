package com.therealdanvega.mtom.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(exclude="categories")
public class Post {

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    @Id @GeneratedValue
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    @Column(columnDefinition = "TEXT")
    private String body;


    /*
     * You don't need to define @JoinTable this if you're ok with the default naming conventions
     * table: post_categories
     * columns: posts_id, categories_id
     */
    // you could also use: @JsonIgnoreProperties("posts")
    @JsonManagedReference
    @ManyToMany( cascade = {CascadeType.PERSIST} )
    @JoinTable(
            name = "post_categories",
            joinColumns = { @JoinColumn(name = "fk_post") },
            inverseJoinColumns = { @JoinColumn(name = "fk_category") }
    )
    private Set<Category> categories = new HashSet<>();

    // helper methods for updating associations on both sides
    public void addCategory(Category category) {
        this.categories.add(category);
        category.getPosts().add(this);
    }

    public void removeCategory(Category category) {
        this.categories.remove(category);
        category.getPosts().remove(this);
    }
}
