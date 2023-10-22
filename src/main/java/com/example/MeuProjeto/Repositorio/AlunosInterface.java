package com.example.MeuProjeto.Repositorio;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MeuProjeto.Models.Aluno;

@Repository
public interface AlunosInterface extends JpaRepository<Aluno,UUID> {
    
    
}
