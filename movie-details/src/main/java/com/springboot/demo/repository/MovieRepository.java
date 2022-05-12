package com.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.demo.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
