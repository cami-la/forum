package br.com.alura.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class NovoTopicoForm(
  @field:NotEmpty(message = "Titulo não pode ser em branco")
  @field:Size(
    min = 5,
    max = 100,
    message = "Título deve ter entre 5 e 100 caracteres."
  ) val titulo: String,
  @field:NotEmpty (message = "Mensagem não pode ser em branco") val mensagem: String,
  @field:NotEmpty val idCurso: Long,
  @field:NotEmpty val idAutor: Long
) {

}
