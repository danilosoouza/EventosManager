package app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.Model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer>{

}
