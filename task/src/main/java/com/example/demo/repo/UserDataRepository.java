package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserData;

public interface UserDataRepository extends JpaRepository<UserData, Integer> {

	Optional<UserData>findByName(String username);
}