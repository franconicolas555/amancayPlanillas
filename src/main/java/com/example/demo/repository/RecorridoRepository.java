package com.example.demo.repository;

import com.example.demo.entity.Recorrido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecorridoRepository extends JpaRepository<Recorrido, Long> {

    @Query(value = "SELECT * FROM recorridos ", nativeQuery = true)
    List<Recorrido> getRecorridos();

    @Query(value = "SELECT * FROM recorridos where id_afiliado = :id_afiliado ", nativeQuery = true)
    List<Recorrido> getRecorridosByAfiliado(@Param("id_afiliado") Long idAfiliado);
}
