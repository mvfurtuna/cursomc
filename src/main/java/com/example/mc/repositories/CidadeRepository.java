package com.example.mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mc.domain.Cidade;


public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
