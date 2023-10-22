package com.example.MeuProjeto.Controller;

import java.util.Optional;
import java.util.UUID;

import org.hibernate.mapping.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MeuProjeto.DtoAlunos.DtoAlunos;
import com.example.MeuProjeto.Models.Aluno;
import com.example.MeuProjeto.Repositorio.AlunosInterface;
import jakarta.validation.Valid;

@RestController

public class AlunosController {
    
    @Autowired
    AlunosInterface alunosInterface;

    @PostMapping("/post")
    public ResponseEntity<Aluno> saveAluno(@RequestBody @Valid DtoAlunos dtoAlunos){
        var aluno = new Aluno();
        BeanUtils.copyProperties(dtoAlunos,aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunosInterface.save(aluno));
    }
    /**
     * @return
     */
    @GetMapping("/getAll")
    public ResponseEntity <java.util.List<Aluno>> getAllAlunos(){
        return ResponseEntity.status(HttpStatus.OK).body(alunosInterface.findAll());
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Object> getAluno(@PathVariable(value = "id") UUID id){
        Optional<Aluno> aluno1 = alunosInterface.findById(id);
        if(aluno1.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Elemento não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(aluno1.get());}

    @PutMapping("/alter/{id}")
    public ResponseEntity<Object> alterAluno(@PathVariable(value = "id") UUID id , @RequestBody @Valid DtoAlunos dtoAlunos){
        Optional<Aluno> alunooOptional = alunosInterface.findById(id);
        if(alunooOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        var AlunoAlter = alunooOptional.get();
        BeanUtils.copyProperties(dtoAlunos, AlunoAlter);
        return ResponseEntity.status(HttpStatus.OK).body(alunosInterface.save(AlunoAlter));

    }
    






}
