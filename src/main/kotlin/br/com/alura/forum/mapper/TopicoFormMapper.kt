package br.com.alura.forum.mapper

import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.entity.Topico
import br.com.alura.forum.service.CursoService
import br.com.alura.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
  private val cursoService: CursoService,
  private val usuarioService: UsuarioService
) : Mapper<NovoTopicoForm, Topico> {
  
  override fun map(t: NovoTopicoForm): Topico {
    return Topico(
      mensagem = t.mensagem,
      titulo = t.titulo,
      curso = cursoService.buscaCursoPorId(t.idCurso),
      autor = usuarioService.buscaUsuarioPorId(t.idAutor)
    )
  }
  
}
