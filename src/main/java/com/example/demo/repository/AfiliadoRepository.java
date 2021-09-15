package com.example.demo.repository;

import com.example.demo.entity.Afiliado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AfiliadoRepository extends CrudRepository<Afiliado, Long> {
    @Query(value = "SELECT id_afiliado FROM afiliados ", nativeQuery = true)
    List<Long> getAfiliados();
}
