package br.com.alura.forum.controller

import br.com.alura.forum.dto.TopicoDto
import br.com.alura.forum.entity.Topico
import br.com.alura.forum.service.TopicoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topicos")
class TopicoController(
  private val topicoService: TopicoService
) {
  
  @GetMapping
  fun listar() : List<Topico> {
    return topicoService.listar()
  }
  
  @GetMapping("/{id}")
  fun buscarPorId(@PathVariable id: Long) : Topico {
    return topicoService.buscarPorId(id)
  }
  
  @PostMapping
  fun cadastrar(@RequestBody topico: TopicoDto) {
    topicoService.cadastrar(topico)
  }
}

