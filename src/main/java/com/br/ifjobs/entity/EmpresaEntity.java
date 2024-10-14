package com.br.ifjobs.entity;

import com.br.ifjobs.enums.StatusEmpresaEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "empresa")
@Table(name = "TB_EMPRESAS")
public class EmpresaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_empresas")
    @SequenceGenerator(sequenceName = "seq_empresas", name = "seq_empresas", allocationSize = 1)
    @Column(name = "id_empresa")
    private Integer idEmpresa;

    @JsonIgnore
    @OneToMany(mappedBy = "empresa")
    private Set<VagaEntity> vagas;

    @Column(name = "cnpj_empresa")
    private String cnpjEmpresa;

    @Column(name = "nm_empresa")
    private String nomeEmpresa;

    @Column(name = "desc_empresa")
    private String descEmpresa;

    @Column(name = "status_empresa")
    private StatusEmpresaEnum statusEmpresa;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
