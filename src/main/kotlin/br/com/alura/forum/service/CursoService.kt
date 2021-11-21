package br.com.alura.forum.service

import br.com.alura.forum.entity.Curso
import org.springframework.stereotype.Service
import java.util.*

@Service
data class CursoService(
  var cursos: List<Curso>
) {
  
  init {
    val curso1 = Curso(
      id = 1,
      nome = "Curso de Kotlin - Variáveis",
      categoria = "Programação"
    )
   /* val curso2 = Curso(
      id = 2,
      nome = "Curso de Kotlin - Estrutura de repetição",
      categoria = "Programação"
    )
    val curso3 = Curso(
      id = 3,
      nome = "Curso de Kotlin - Laço de repetição",
      categoria = "Programação"
    )*/
    cursos = Arrays.asList(curso1)
  }
  
  fun buscaCursoPorId(id: Long) : Curso {
    return cursos.stream()
      .filter { c ->
        c.id == id }
      .findFirst()
      .get()
  }

}
