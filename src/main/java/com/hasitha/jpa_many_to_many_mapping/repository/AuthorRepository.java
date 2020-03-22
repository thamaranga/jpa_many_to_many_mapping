package com.hasitha.jpa_many_to_many_mapping.repository;

import com.hasitha.jpa_many_to_many_mapping.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
