package com.project.allef.apirest.Repository;

import com.project.allef.apirest.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface eventoRepository extends JpaRepository<Evento,String> {


}
