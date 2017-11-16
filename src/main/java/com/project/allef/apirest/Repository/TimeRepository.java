package com.project.allef.apirest.Repository;

import com.project.allef.apirest.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * classe responsavel por iniciar o Jpa para persistencia no banco
 * para ser acessada por outra classe
 */

public interface TimeRepository extends JpaRepository<Time,String> {

    Time findByCodigo(long codigo);

}
