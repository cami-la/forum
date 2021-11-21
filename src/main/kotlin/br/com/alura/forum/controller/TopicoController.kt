package br.com.alura.forum.controller

import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.dto.atualizacaoTopicoForm
import br.com.alura.forum.service.TopicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(
  private val topicoService: TopicoService
) {
  
  @GetMapping
  fun listarTopicos(): List<TopicoView> {
    return topicoService.listarTopicos()
  }
  
  @GetMapping("/{id}")
  fun buscarTopicoPorId(@PathVariable id: Long): TopicoView {
    return topicoService.buscarTopicoPorId(id)
  }
  
  @PostMapping
  fun cadastrarTopico(
    @RequestBody @Valid form: NovoTopicoForm,
    uriBuilder: UriComponentsBuilder
  ): ResponseEntity<TopicoView> {
    val topicoView = topicoService.cadastrarTopico(form)
    
    val uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri()
    
    return ResponseEntity.created(uri).body(topicoView)
  }
  
  @PutMapping
  fun atualizarTopico(@RequestBody @Valid form: atualizacaoTopicoForm): ResponseEntity<TopicoView> {
    val topicoAtualizado = topicoService.atualizarTopico(form)
    
    return ResponseEntity.ok(topicoAtualizado)
  }
  
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  fun deleteTopico(@PathVariable id: Long) {
    topicoService.deleteTopico(id)
  }
  
}