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
import br.com.alura.forum.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(
  private val repository: TopicoRepository,
  private val topicoViewMapper: TopicoViewMapper,
  private val topicoFormMapper: TopicoFormMapper,
  private val notFoundMessage: String = "Tópico não encontrado"
) {
  
  fun listarTopicos(): List<TopicoView> {
    return repository.findAll()
      .stream()
      . map { t -> topicoViewMapper.map(t) }
      .collect(Collectors.toList())
    
  }
  
  fun buscarTopicoPorId(id: Long): TopicoView {
    val topico = repository.findById(id).stream()
      .filter { t ->
        t.id == id
      }.findFirst()
      .orElseThrow { NotFoundException(notFoundMessage) }
    
    return topicoViewMapper.map(topico)
  }
  
  fun cadastrarTopico(form: NovoTopicoForm): TopicoView {
    val novoTopico = topicoFormMapper.map(form)
    repository.save(novoTopico)
    
    return topicoViewMapper.map(novoTopico)
  }
  
  fun atualizarTopico(form: atualizacaoTopicoForm): TopicoView {
  
    val topico = repository.findById(form.id)
      .orElseThrow({ NotFoundException(notFoundMessage) })
    
    topico.titulo = form.titulo
    topico.mensagem = form.mensagem
    
    //repository.save(topico)
    
    return topicoViewMapper.map(topico)
  }
  
  fun deleteTopico(id: Long) {
    val topico = repository.findById(id).stream()
      .filter { t ->
        t.id == id
      }.findFirst()
      .orElseThrow { NotFoundException(notFoundMessage) }
    
    repository.delete(topico)
    
  }
  
  
}
