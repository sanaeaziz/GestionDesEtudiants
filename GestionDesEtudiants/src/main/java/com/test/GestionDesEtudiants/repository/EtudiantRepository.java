package com.test.GestionDesEtudiants.repository;

import com.test.GestionDesEtudiants.models.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface EtudiantRepository extends JpaRepository< Etudiant, Long> {
    public List<Etudiant> findByName(String name);
    public Page<Etudiant> findByName(String name, Pageable pageable);
    @Query("select e from Etudiant e where e.dateNaissance >:x and e.dateNaissance <:y")
    public List<Etudiant> searchEtudiants(@Param("x")Date d1,@Param("y")Date d2);
  @Query("select e from Etudiant e where e.cne like :x")
    public Page<Etudiant> searchEtudiantsCNE(@Param("x")String cne, Pageable pageable);
}
