package com.lab9.springboot.repository;

import com.lab9.springboot.model.Masina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MasinaRepository extends JpaRepository<Masina,String> {

    int countByMarca(String marca);

    void deleteByNrInmatriculare(String nrInmatriculare);

    int countByKmLessThan(int pragKilometri);

    List<Masina> findByAnFabricatieGreaterThan(int an);

    List<Masina> findByNrInmatriculare(String nrInmatriculare);

    @Query("select m from Masina m where m.anFabricatie > :an")
    List<Masina> findMasiniMaiNoiDe(int an);


}
