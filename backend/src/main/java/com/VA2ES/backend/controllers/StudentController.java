package com.VA2ES.backend.controllers;

import com.VA2ES.backend.dto.StudentRequestDTO;
import com.VA2ES.backend.dto.StudentResponseDTO;
import com.VA2ES.backend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponseDTO> create(@RequestBody StudentRequestDTO dto) {
        return ResponseEntity.ok(studentService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> list() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> update(@PathVariable Long id, @RequestBody StudentRequestDTO dto) {
        return ResponseEntity.ok(studentService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
