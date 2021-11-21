package br.com.alura.forum.entity

import java.time.LocalDate
import java.time.LocalDateTime

data class Topico(
  var id: Long? = null,
  val titulo: String,
  val mensagem: String,
  val dataCriacao : LocalDateTime = LocalDateTime.now(),
  val curso: Curso,
  val autor: Usuario,
  val statusTopico: StatusTopico = StatusTopico.NAO_RESPONDIDO,
  val respostas: List<Resposta> = ArrayList<Resposta>()
)
