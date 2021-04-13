package com.silva.agenda.agenda.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.silva.agenda.agenda.model.Agenda;

@Repository
public interface IAgendaRepository extends JpaRepository<Agenda, Long>{

	Optional<Date> findByData(Date data);

	Optional<String> findByNomeCompromisso(String nomeCompromisso);

}
