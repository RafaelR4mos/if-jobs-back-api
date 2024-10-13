package com.br.ifjobs.entity;

import com.br.ifjobs.enums.StatusVagaEnum;
import com.br.ifjobs.enums.TipoJornadaVagaEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Set;

@Entity(name = "vaga")
@Table(name = "TB_VAGAS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VagaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vagas")
    @SequenceGenerator(sequenceName = "seq_vagas", name = "seq_vagas", allocationSize = 1)
    @Column(name = "id_vaga")
    private Integer idVaga;

    @ManyToOne
    private Set<EmpresaEntity> empresa;

    @Column(name = "nm_vaga")
    private String nmVaga;

    @Column(name = "desc_vaga")
    private String descVaga;

    @Column(name = "tipo_jornada")
    private TipoJornadaVagaEnum tipoJornada;

    @Column(name = "status_vaga")
    private StatusVagaEnum statusVaga;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;


    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
