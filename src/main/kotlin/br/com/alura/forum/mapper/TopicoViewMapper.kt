package br.com.alura.forum.mapper

import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.entity.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper : Mapper<Topico, TopicoView> {
  
  override fun map(t: Topico): TopicoView {
    return  TopicoView(
    id = t.id,
    titulo = t.titulo,
    mensagem = t.mensagem,
    status = t.statusTopico,
    dataCriacao = t.dataCriacao)
  }
  
}