package com.br.ifjobs.controller;

import com.br.ifjobs.dto.Empresa.EmpresaCreateDTO;
import com.br.ifjobs.dto.Empresa.EmpresaDTO;
import com.br.ifjobs.dto.Empresa.EmpresaUpdateDTO;
import com.br.ifjobs.exception.RegraDeNegocioException;
import com.br.ifjobs.service.EmpresaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
@RequiredArgsConstructor
@Tag(description = "Endpoints para Empresa", name = "Empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<EmpresaDTO> create(@RequestBody EmpresaCreateDTO empresaCreateDTO) {
        return new ResponseEntity<>(empresaService.create(empresaCreateDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmpresaDTO>> findAll() {
        return new ResponseEntity<>(empresaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{idEmpresa}")
    public ResponseEntity<EmpresaDTO> findById(@PathVariable Integer idEmpresa) throws RegraDeNegocioException {
        return new ResponseEntity<>(empresaService.findById(idEmpresa), HttpStatus.OK);
    }

    @PutMapping("/{idEmpresa}")
    public ResponseEntity<EmpresaDTO> update(@RequestBody EmpresaUpdateDTO empresaUpdateDTO, @PathVariable Integer idEmpresa) throws RegraDeNegocioException {
        return new ResponseEntity<>(empresaService.update(empresaUpdateDTO, idEmpresa), HttpStatus.OK);
    }

    @DeleteMapping("/{idEmpresa}")
    public ResponseEntity delete(@PathVariable Integer idEmpresa) throws RegraDeNegocioException {
        empresaService.delete(idEmpresa);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
