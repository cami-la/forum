package br.com.alura.forum.dto

data class TopicoDto(
  val titulo: String,
  val mensagem: String,
  val idCurso: Long,
  val idAutor: Long
) {

}
