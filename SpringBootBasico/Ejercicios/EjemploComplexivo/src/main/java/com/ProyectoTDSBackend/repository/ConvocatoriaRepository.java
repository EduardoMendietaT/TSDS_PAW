/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoTDSBackend.repository;

import com.ProyectoTDSBackend.models.Convocatoria;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LENOVO
 */
@Repository
public interface ConvocatoriaRepository extends JpaRepository<Convocatoria, Long> {

    @Query(value = "select * from convocatoria c where c.fechainicio =:fechainicio order by c.idconvocatoria desc ", nativeQuery = true)
    List<Convocatoria> findByfechainicio(Date fechainicio);

    @Query(value = "select * from convocatoria c where c.fechafin =:fechafin order by c.idconvocatoria desc ", nativeQuery = true)
    List<Convocatoria> findByfechafin(Date fechafin);

    @Query(value = "select * from convocatoria c where c.idcarrera =:idcarrera order by c.idconvocatoria desc ", nativeQuery = true)
    List<Convocatoria> findByidcarrera(Long idcarrera);

    @Query(value = "select * from convocatoria c where c.idresponsableppp =:idresponsableppp order by c.idconvocatoria desc ", nativeQuery = true)
    List<Convocatoria> findByidresponsableppp(Long idresponsableppp);

    @Query(value = "select * from convocatoria c where c.estado = 1 order by c.idconvocatoria desc ", nativeQuery = true)
    List<Convocatoria> findAllConvocatoriasActivas();

    @Query(value = "select * from convocatoria c where c.estado = 0 order by c.idconvocatoria desc ", nativeQuery = true)
    List<Convocatoria> findAllConvocatoriasInactivas();

}
