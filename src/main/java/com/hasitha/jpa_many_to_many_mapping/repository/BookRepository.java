package com.hasitha.jpa_many_to_many_mapping.repository;

import com.hasitha.jpa_many_to_many_mapping.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
