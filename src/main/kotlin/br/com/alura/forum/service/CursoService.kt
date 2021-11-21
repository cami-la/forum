package br.com.alura.forum.service

import br.com.alura.forum.entity.Curso
import br.com.alura.forum.repository.CursoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
data class CursoService(
  private val repository: CursoRepository
) {
  
  fun buscaCursoPorId(id: Long) : Curso {
    return repository.getById(id)
  }

}
