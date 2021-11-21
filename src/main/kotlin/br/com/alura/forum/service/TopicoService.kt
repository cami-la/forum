package br.com.alura.forum.service

import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.dto.atualizacaoTopicoForm
import br.com.alura.forum.entity.Curso
import br.com.alura.forum.entity.Topico
import br.com.alura.forum.entity.Usuario
import br.com.alura.forum.exceptions.NotFoundException
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoViewMapper
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(
  private var topicos: List<Topico> = ArrayList(),
  private val topicoViewMapper: TopicoViewMapper,
  private val topicoFormMapper: TopicoFormMapper,
  private val notFoundMessage: String = "Tópico não encontrado"
) {
  
  init {
    val topico1: Topico = Topico(
      id = 1,
      titulo = "Duvida Kotlin",
      mensagem = "Variáveis em Kotlin",
      curso = Curso(
        nome = "Kotlin",
        categoria = "Programação"
      ),
      autor = Usuario(
        nome = "Ana",
        email = "ana@email.com"
      )
    )
    
    val topico2: Topico = Topico(
      id = 2,
      titulo = "Duvida Kotlin 2",
      mensagem = "Variáveis em Kotlin 2",
      curso = Curso(
        nome = "Kotlin",
        categoria = "Programação"
      ),
      autor = Usuario(
        nome = "Ana",
        email = "ana@email.com"
      )
    )
    
    val topico3: Topico = Topico(
      id = 3,
      titulo = "Duvida Kotlin 3",
      mensagem = "Variáveis em Kotlin 3",
      curso = Curso(
        nome = "Kotlin",
        categoria = "Programação"
      ),
      autor = Usuario(
        nome = "Ana",
        email = "ana@email.com"
      )
    )
    topicos = Arrays.asList(topico1, topico2, topico3)
  }
  
  fun listarTopicos(): List<TopicoView> {
    return topicos.stream().map { t ->
      topicoViewMapper.map(t)
    }
      .collect(Collectors.toList())
    
  }
  
  fun buscarTopicoPorId(id: Long): TopicoView {
    val topicoView = topicos.stream()
      .filter { t ->
        t.id == id
      }.findFirst()
      .orElseThrow { NotFoundException(notFoundMessage) }
    
    return topicoViewMapper.map(topicoView)
  }
  
  fun cadastrarTopico(form: NovoTopicoForm): TopicoView {
    val topico = topicoFormMapper.map(form)
    topico.id = topicos.size.toLong() + 1
    
    topicos = topicos.plus(topico)
    
    return topicoViewMapper.map(topico)
  }
  
  fun atualizarTopico(form: atualizacaoTopicoForm): TopicoView {
    val topico = topicos.stream().filter { t ->
      t.id == form.id
    }
      .findFirst()
      .orElseThrow { NotFoundException(notFoundMessage) }
    
    val topicoAtualizado = Topico(
      id = form.id,
      titulo = form.titulo,
      mensagem = form.mensagem,
      autor = topico.autor,
      curso = topico.curso,
      respostas = topico.respostas,
      statusTopico = topico.statusTopico,
      dataCriacao = topico.dataCriacao
    )
    
    topicos = topicos.minus(topico).plus(topicoAtualizado)
    
    return topicoViewMapper.map(topicoAtualizado)
  }
  
  fun deleteTopico(id: Long) {
    val topico = topicos.stream().filter { t ->
      t.id == id
    }
      .findFirst()
      .orElseThrow { NotFoundException(notFoundMessage) }
    
    topicos = topicos.minus(topico)
    
  }
  
  
}
