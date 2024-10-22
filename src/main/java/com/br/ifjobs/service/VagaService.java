package com.br.ifjobs.service;

import com.br.ifjobs.dto.PageDTO;
import com.br.ifjobs.dto.Vaga.VagaCreateDTO;
import com.br.ifjobs.dto.Vaga.VagaDTO;
import com.br.ifjobs.dto.Vaga.VagaUpdateDTO;
import com.br.ifjobs.entity.EmpresaEntity;
import com.br.ifjobs.entity.VagaEntity;
import com.br.ifjobs.exception.RegraDeNegocioException;
import com.br.ifjobs.repository.VagaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VagaService {

    private final EmpresaService empresaService;
    private final VagaRepository vagaRepository;
    private final ObjectMapper objectMapper;

    public VagaDTO create(VagaCreateDTO vagaCreateDTO) throws RegraDeNegocioException {
        VagaEntity vagaEntity = objectMapper.convertValue(vagaCreateDTO, VagaEntity.class);

        if (vagaCreateDTO.getIdEmpresa() != null) {
            EmpresaEntity empresa = empresaService.getEmpresa(vagaCreateDTO.getIdEmpresa());
            vagaEntity.setEmpresa(empresa);
        }

        VagaEntity vagaEntitySaved = vagaRepository.save(vagaEntity);

        return convertEntityToDTO(vagaEntitySaved);
    }

    public PageDTO<VagaDTO> findAll(Integer page, Integer pageSize, String jobTitle, String sortField, String sortType) {
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(
                Sort.Direction.fromString(sortType), sortField)
        );
        Page<VagaEntity> allJobs;

        if (jobTitle != null) {
            allJobs = vagaRepository.findAllByNmVagaContainingIgnoreCase(pageRequest, jobTitle.trim());
        } else {
            allJobs = vagaRepository.findAll(pageRequest);
        }

        List<VagaDTO> content = allJobs.getContent().stream().map(this::convertEntityToDTO).toList();

        return new PageDTO<>(allJobs.getTotalElements(), allJobs.getTotalPages(), page, pageSize, content);
    }

    public VagaDTO findById(Integer idVaga) throws RegraDeNegocioException {
        VagaEntity vagaEntity = getVaga(idVaga);
        return convertEntityToDTO(vagaEntity);
    }

    public VagaDTO update(VagaUpdateDTO vagaUpdateDTO, Integer idVaga) throws RegraDeNegocioException {
        VagaEntity vagaEntity = getVaga(idVaga);

        if (vagaUpdateDTO.getNmVaga() != null) vagaEntity.setNmVaga(vagaUpdateDTO.getNmVaga());
        if (vagaUpdateDTO.getDescVaga() != null) vagaEntity.setDescVaga(vagaUpdateDTO.getDescVaga());
        if (vagaUpdateDTO.getTipoJornada() != null) vagaEntity.setTipoJornada(vagaUpdateDTO.getTipoJornada());
        if (vagaUpdateDTO.getStatusVaga() != null) vagaEntity.setStatusVaga(vagaUpdateDTO.getStatusVaga());

        if (vagaUpdateDTO.getIdEmpresa() != null) {
            EmpresaEntity empresa = empresaService.getEmpresa(vagaUpdateDTO.getIdEmpresa());
            vagaEntity.setEmpresa(empresa);
        }

        VagaEntity vagaEntitySaved = vagaRepository.save(vagaEntity);

        return convertEntityToDTO(vagaEntitySaved);
    }

    public void delete(Integer idVaga) throws RegraDeNegocioException {
        VagaEntity vagaEntity = getVaga(idVaga);
        vagaRepository.delete(vagaEntity);
    }

    public VagaEntity getVaga(Integer idVaga) throws RegraDeNegocioException {
        return vagaRepository.findById(idVaga)
                .orElseThrow(() -> new RegraDeNegocioException("Vaga de id " + idVaga + " não encontrada"));
    }


    private VagaDTO convertEntityToDTO(VagaEntity vagaEntity) {
        VagaDTO vagaDTO = new VagaDTO();
        vagaDTO.setDescVaga(vagaEntity.getDescVaga());
        vagaDTO.setIdVaga(vagaEntity.getIdVaga());
        vagaDTO.setNmVaga(vagaEntity.getNmVaga());
        vagaDTO.setTipoJornada(vagaEntity.getTipoJornada());
        vagaDTO.setStatusVaga(vagaEntity.getStatusVaga());
        vagaDTO.setCreatedAt(vagaEntity.getCreatedAt());
        vagaDTO.setUpdatedAt(vagaEntity.getUpdatedAt());
        if (vagaEntity.getEmpresa() != null) vagaDTO.setIdEmpresa(vagaEntity.getEmpresa().getIdEmpresa());

        return vagaDTO;
    }
}
