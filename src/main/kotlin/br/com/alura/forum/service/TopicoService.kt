package br.com.alura.forum.service

import br.com.alura.forum.dto.TopicoDto
import br.com.alura.forum.entity.Topico
import org.springframework.stereotype.Service
import kotlin.collections.ArrayList

@Service
class TopicoService(
  private var topicos: List<Topico> = ArrayList<Topico>(),
  private val cursoService: CursoService,
  private val autorService: UsuarioService
) {
  
  fun listar(): List<Topico> {
    return topicos
  }
  
  fun buscarPorId(id: Long): Topico {
    return topicos.stream().filter { t ->
      t.id == id
    }.findFirst().get()
  }
  
  fun cadastrar(dto: TopicoDto) {
    topicos.plus(Topico(
      id = 1,
      titulo = dto.titulo,
      mensagem = dto.mensagem,
      curso = cursoService.buscarCursoPorId(dto.idCurso),
      autor = autorService.buscaUsuarioPorId(dto.idAutor)
    ))
  }
  
}