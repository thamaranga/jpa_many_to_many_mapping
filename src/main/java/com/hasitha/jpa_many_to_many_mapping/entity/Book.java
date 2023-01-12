package com.hasitha.jpa_many_to_many_mapping.entity;

import com.hasitha.jpa_many_to_many_mapping.entity.Author;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
/*This is considered as the parent entity*/
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookName;
    /*
    * CascadeType.PERSIST means while saving parent data, pls save child data also.
    * So while performing other actions like DELETE , child entity will not be affected.
    * */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name="author2books",
    joinColumns = @JoinColumn(name="bookId"),
    inverseJoinColumns = @JoinColumn(name="authorId"))
    private List<Author> listOfAuthors= new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<Author> getListOfAuthors() {
        return listOfAuthors;
    }

    public void setListOfAuthors(List<Author> listOfAuthors) {
        this.listOfAuthors = listOfAuthors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
