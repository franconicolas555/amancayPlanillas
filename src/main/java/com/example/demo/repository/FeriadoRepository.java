package com.example.demo.repository;

import com.example.demo.entity.Feriado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;


@Repository
public interface FeriadoRepository extends CrudRepository<Feriado, Long> {

    @Query(value = "SELECT EXTRACT(DAY FROM fecha_feriado) FROM feriados where fecha_feriado between :fecd and :fech", nativeQuery = true)
    Integer getFeriados(@Param("fecd") Timestamp fecd, @Param("fech") Timestamp fech);
}
