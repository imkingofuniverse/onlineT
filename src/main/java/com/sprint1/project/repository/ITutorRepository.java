package com.sprint1.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint1.project.entity.Tutor;


public interface ITutorRepository extends JpaRepository<Tutor, String> {

}
