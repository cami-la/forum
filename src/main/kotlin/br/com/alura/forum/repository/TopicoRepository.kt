package br.com.alura.forum.repository

import br.com.alura.forum.entity.Topico
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicoRepository : JpaRepository<Topico, Long> {

}