/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoTDSBackend.repository;

import com.ProyectoTDSBackend.models.Actividad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LENOVO
 */
@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long>{
    
    Optional<Actividad> findByCronograma(String nombrCrono);

    

    //@Query(value = "select * from productos  where estado =1", nativeQuery = true)
    //List<Producto> search(int estado);

//    @Query(value = "select * from productos  where estado_producto =1",nativeQuery = true)
//    List<Actividad> findAllActiveActividadNative();
    
}
