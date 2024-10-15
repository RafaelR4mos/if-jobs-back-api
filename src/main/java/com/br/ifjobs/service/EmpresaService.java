package com.br.ifjobs.service;

import com.br.ifjobs.dto.Empresa.EmpresaCreateDTO;
import com.br.ifjobs.dto.Empresa.EmpresaDTO;
import com.br.ifjobs.dto.Empresa.EmpresaUpdateDTO;
import com.br.ifjobs.entity.EmpresaEntity;
import com.br.ifjobs.exception.RegraDeNegocioException;
import com.br.ifjobs.repository.EmpresaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final ObjectMapper objectMapper;

    public EmpresaDTO create(EmpresaCreateDTO empresaCreateDTO) {
        EmpresaEntity entity = objectMapper.convertValue(empresaCreateDTO, EmpresaEntity.class);

        return  objectMapper.convertValue(empresaRepository.save(entity), EmpresaDTO.class);
    }

    public List<EmpresaDTO> findAll() {
        List<EmpresaDTO> empresas = empresaRepository.findAll()
                .stream()
                .map(empresa -> objectMapper.convertValue(empresa, EmpresaDTO.class))
                .toList();

        return empresas;
    }

    public EmpresaDTO findById(Integer idEmpresa) throws RegraDeNegocioException {
        EmpresaEntity empresaEntity = getEmpresa(idEmpresa);
        return objectMapper.convertValue(empresaEntity, EmpresaDTO.class);
    }

    public EmpresaDTO update(EmpresaUpdateDTO empresaUpdateDTO, Integer empresaId) throws RegraDeNegocioException {
        EmpresaEntity empresaEntity = getEmpresa(empresaId);

        if(empresaUpdateDTO.getNomeEmpresa() != null) empresaEntity.setNomeEmpresa(empresaUpdateDTO.getNomeEmpresa());
        if(empresaUpdateDTO.getCnpjEmpresa() != null) empresaEntity.setCnpjEmpresa(empresaUpdateDTO.getCnpjEmpresa());
        if(empresaUpdateDTO.getDescEmpresa() != null) empresaEntity.setDescEmpresa(empresaUpdateDTO.getDescEmpresa());
        if(empresaUpdateDTO.getStatusEmpresa() != null) empresaEntity.setStatusEmpresa(empresaUpdateDTO.getStatusEmpresa());

        return objectMapper.convertValue(empresaRepository.save(empresaEntity), EmpresaDTO.class);
    }

    public void delete(Integer empresaId) throws RegraDeNegocioException {
        EmpresaEntity empresaEntity = getEmpresa(empresaId);

        empresaRepository.deleteById(empresaEntity.getIdEmpresa());
    }

    public EmpresaEntity getEmpresa(Integer empresaId) throws RegraDeNegocioException {
        return empresaRepository.findById(empresaId)
                .orElseThrow(() -> new RegraDeNegocioException("Empresa de id " + empresaId + " não encontrada."));
    }
}
