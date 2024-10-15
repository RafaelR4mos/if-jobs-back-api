package com.br.ifjobs.controller;

import com.br.ifjobs.dto.PageDTO;
import com.br.ifjobs.dto.Vaga.VagaCreateDTO;
import com.br.ifjobs.dto.Vaga.VagaDTO;
import com.br.ifjobs.dto.Vaga.VagaUpdateDTO;
import com.br.ifjobs.exception.RegraDeNegocioException;
import com.br.ifjobs.service.VagaService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vaga")
@Tag(description = "Endpoints para Vagas", name = "Vaga")
@RequiredArgsConstructor
public class VagaController {

    private final VagaService vagaService;

    @PostMapping
    public ResponseEntity<VagaDTO> create(@Valid @RequestBody VagaCreateDTO vagaCreateDTO) throws RegraDeNegocioException {
        return new ResponseEntity<>(vagaService.create(vagaCreateDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<PageDTO<VagaDTO>> findAll(@RequestParam(required = false, defaultValue = "0") Integer page,
                                                    @RequestParam(required = false, defaultValue = "15") Integer pageSize,
                                                    @RequestParam(required = false) String nomeVaga,
                                                    @Parameter(description = "Sorting field", schema = @Schema(allowableValues = {"idVaga", "nmVaga", "createdAt", "updatedAt", "statusVaga", "tipoJornada"}, defaultValue = "idVaga"))
                                                        @RequestParam(required = false, defaultValue = "idVaga") String sortField,
                                                    @Parameter(description = "Sorting type", schema = @Schema(allowableValues = {"asc", "desc"}, defaultValue = "desc"))
                                                    @RequestParam(required = false, defaultValue = "desc") String sortType
                                                    ) {
        return new ResponseEntity<>(vagaService.findAll(page, pageSize, nomeVaga, sortField, sortType), HttpStatus.OK);
    }

    @GetMapping("/{idVaga}")
    public ResponseEntity<VagaDTO> findById(@PathVariable Integer idVaga) throws RegraDeNegocioException {
        return new ResponseEntity<>(vagaService.findById(idVaga), HttpStatus.OK);
    }

    @PutMapping("/{idVaga}")
    public ResponseEntity<VagaDTO> update(@Valid @RequestBody VagaUpdateDTO vagaUpdateDTO, @PathVariable Integer idVaga) throws RegraDeNegocioException {
        return new ResponseEntity<>(vagaService.update(vagaUpdateDTO, idVaga), HttpStatus.OK);
    }

    @DeleteMapping("/{idVaga}")
    public ResponseEntity<?> delete(@PathVariable Integer idVaga) throws RegraDeNegocioException {
        vagaService.delete(idVaga);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
